package com.liuhll.hl.auth.service;

import com.liuhll.hl.common.exception.UnAuthenticationException;

public interface IAuthService {
    String login(String userName,String password) throws UnAuthenticationException;
}
