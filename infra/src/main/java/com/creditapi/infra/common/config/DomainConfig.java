package com.creditapi.infra.common.config;

import com.creditapi.domain.common.usecase.DomainComponent;
import com.creditapi.domain.common.usecase.MessageDriven;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.creditapi.domain",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = DomainComponent.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MessageDriven.class)
        }

)
public class DomainConfig {
}
