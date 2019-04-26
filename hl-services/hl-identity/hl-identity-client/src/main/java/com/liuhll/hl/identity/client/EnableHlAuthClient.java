package com.liuhll.hl.identity.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableServiceAuthClient
@EnableUserAuthClient
public @interface EnableHlAuthClient {
}
