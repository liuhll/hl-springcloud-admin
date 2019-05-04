package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.UserInfo;
import com.liuhll.hl.auth.mapper.UserInfoMapper;
import com.liuhll.hl.common.core.service.impl.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

@Service
public class UserInfoService extends BaseService<UserInfoMapper,UserInfo> {


    public UserInfo selectUserByAccount(String account){
        Example example = Example.builder(UserInfo.class)
                .where(Sqls.custom()
                        .orEqualTo("userName",account)
                        .orEqualTo("email",account)
                        .orEqualTo("phone",account))
                .build();
        return mapper.selectOneByExample(example);
    }
}
