package com.creditapi.infra;

import com.creditapi.domain.common.usecase.DomainComponent;
import com.creditapi.domain.common.usecase.MessageDriven;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
public class InfraApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfraApplication.class, args);
    }

}
