package com.creditapi.infra.user.adapter.rest.dto.query;

import com.creditapi.domain.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserResponse {

    private Long id;

    public static RegisterUserResponse from(User user) {
        return RegisterUserResponse.builder()
                .id(user.getId())
                .build();
    }
}
