package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.constant.AuthServerConstant;
import com.liuhll.hl.auth.domain.entity.Employee;
import com.liuhll.hl.auth.domain.entity.UserInfo;
import com.liuhll.hl.auth.mapper.EmployeeMapper;
import com.liuhll.hl.auth.utils.PasswordGenerator;
import com.liuhll.hl.basicdata.client.SysConfigClient;
import com.liuhll.hl.basicdata.common.vo.GetSysConfigOutput;
import com.liuhll.hl.common.core.service.impl.BaseService;
import com.liuhll.hl.common.enums.ResultCode;
import com.liuhll.hl.common.exception.UserFriendlyException;
import com.liuhll.hl.common.vo.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

@Service
public class EmployeeService extends BaseService<EmployeeMapper, Employee> {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordGenerator passwordGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysConfigClient sysConfigClient;

    @Transactional
    public void saveEmployee(Employee employee) {
        validateEmployee(employee);
        save(employee);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(employee, userInfo, "id");
        // :todo 短信形式/Email格式发送随机密码
        if (userInfoService.getMapper().selectOne(userInfo) != null) {
            throw new UserFriendlyException("已经存在该员工信息,请不要重复添加");
        }
        ResponseResult<GetSysConfigOutput> result = sysConfigClient.getSysConfigByName(AuthServerConstant.SYSCONFIG_PWD_MOD);
        if (result.getCode() != ResultCode.Ok){
            throw new UserFriendlyException("获取员工密码模式失败,请先初始化系统");
        }
        userInfo.setPassword(passwordEncoder.encode("123qwe"));
        userInfo.setEmployeeId(employee.getId());
        userInfoService.save(userInfo);
    }

    public Employee selectEmployeeByAccout(String account){
        Example example = Example.builder(Employee.class)
                .where(Sqls.custom()
                        .orEqualTo("userName",account)
                        .orEqualTo("email",account)
                        .orEqualTo("phone",account)
                ).build();
        return mapper.selectOneByExample(example);
    }

    private void validateEmployee(Employee employee){
        if (selectEmployeeByAccout(employee.getUserName()) != null){
            throw new UserFriendlyException("已经存在".concat(employee.getUserName()).concat("的用户名"));
        }
        if (selectEmployeeByAccout(employee.getPhone()) != null){
            throw new UserFriendlyException("手机号码不允许重复");
        }
        if (selectEmployeeByAccout(employee.getEmail()) != null){
            throw new UserFriendlyException("电子邮件不允许重复");
        }
    }
}
