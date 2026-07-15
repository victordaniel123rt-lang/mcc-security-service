package com.vdgarcia.mcc_security_service.util;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mcc-security")
public class MicroservicesProperties {

    List<Application> applications;

    @Data
    public static class Application{
        private String clientId;
        private String clientSecret;
    }

}
