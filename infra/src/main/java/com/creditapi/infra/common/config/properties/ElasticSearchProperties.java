package com.creditapi.infra.common.config.properties;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchProperties {

    @NotNull
    private String host;
    @NotNull
    private Integer port;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
