package com.liuhll.hl.identity.service;

import com.liuhll.hl.identity.domain.entity.UserInfo;

public interface IUserService {
    UserInfo findUserInfoByName(String userName);
}
