package com.intelligence.user.openapi.config;

import com.intelligence.user.openapi.api.FeignBasePackageClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ClientConfiguration.class)
@EnableFeignClients(basePackageClasses = FeignBasePackageClass.class)
public class UserApiConfiguration {}
