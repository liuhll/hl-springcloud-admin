package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.Employee;
import com.liuhll.hl.auth.domain.entity.UserInfo;
import com.liuhll.hl.auth.mapper.EmployeeMapper;
import com.liuhll.hl.common.service.impl.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService extends BaseService<EmployeeMapper, Employee> {

    @Autowired
    private UserInfoService userInfoService;

    @Transactional
    public void saveEmployee(Employee employee){
        save(employee);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(employee,userInfo,"id");
        userInfo.setPassword("123qwe");
        userInfo.setEmployeeid(employee.getId());
//        throw new UserFriendlyException("测试事务");
        userInfoService.save(userInfo);
    }
}
