package com.liuhll.hl.auth.service.impl;

import com.liuhll.hl.auth.domain.entity.UserInfo;
import com.liuhll.hl.auth.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public UserInfo findUserInfoByName(String userName) {
        Integer userId = 1;
        UserInfo userInfo = new UserInfo( userId.longValue(),userName, "123qwe");
        return userInfo;
    }
}
