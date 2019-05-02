package com.liuhll.hl.common.auth.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUserClaims {

    private String userid;

    private String username;
}
