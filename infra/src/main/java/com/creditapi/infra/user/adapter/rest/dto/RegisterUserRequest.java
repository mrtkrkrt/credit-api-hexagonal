package com.creditapi.infra.user.adapter.rest.dto;

import com.creditapi.domain.user.usecase.RegisterUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {
    private String identityNumber;
    private String firstName;
    private String lastName;

    public RegisterUser toUseCase() {
        return RegisterUser.builder()
                .identityNumber(identityNumber)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
