package com.liuhll.hl.identity.domain.service;

import com.liuhll.hl.identity.domain.entity.UserInfo;

public interface UserService {
    UserInfo findUserInfoByName(String userName);
}
