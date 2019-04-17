package com.liuhll.hl.identity.common.jwt;

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
