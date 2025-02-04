package com.creditapi.domain.user.usecase;

import com.creditapi.domain.common.usecase.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUser implements UseCase {
    private String identityNumber;
    private String firstName;
    private String lastName;
}
