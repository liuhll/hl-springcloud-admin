package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.UserInfo;
import com.liuhll.hl.auth.mapper.UserInfoMapper;
import com.liuhll.hl.common.service.impl.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService extends BaseService<UserInfoMapper,UserInfo> {


    public UserInfo selectUserByName(String userName){

        UserInfo userInfo = new UserInfo();
        userInfo.setId(Long.valueOf(1));
        userInfo.setUsername(userName);
        userInfo.setPassword("123qwe");
        return userInfo;
    }
}
