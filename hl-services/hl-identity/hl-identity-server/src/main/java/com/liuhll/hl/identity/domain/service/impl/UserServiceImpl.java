package com.liuhll.hl.identity.domain.service.impl;

import com.liuhll.hl.identity.domain.entity.UserInfo;
import com.liuhll.hl.identity.domain.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo findUserInfoByName(String userName) {
        Integer userId = 1;
        UserInfo userInfo = new UserInfo( userId.longValue(),userName, "123qwe");
        return userInfo;
    }
}
