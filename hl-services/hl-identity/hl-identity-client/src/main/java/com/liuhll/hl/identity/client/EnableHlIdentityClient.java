package com.liuhll.hl.identity.client;

import com.liuhll.hl.identity.client.conf.AutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfiguration.class)
public @interface EnableHlIdentityClient {
}
