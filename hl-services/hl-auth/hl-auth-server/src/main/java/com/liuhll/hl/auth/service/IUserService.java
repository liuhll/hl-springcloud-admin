package com.liuhll.hl.auth.service;

import com.liuhll.hl.auth.domain.entity.UserInfo;

public interface IUserService {
    UserInfo findUserInfoByName(String userName);
}
