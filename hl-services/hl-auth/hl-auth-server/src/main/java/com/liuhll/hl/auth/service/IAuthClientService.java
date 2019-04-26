package com.liuhll.hl.auth.service;

public interface IAuthClientService {
    void validate(String clientId,String clientSecret);
}
