package com.liuhll.hl.identity.domain.service;

import com.liuhll.hl.common.exception.UnAuthenticationException;

public interface AuthService {
    String login(String userName,String password) throws UnAuthenticationException;
}
