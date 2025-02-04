package com.creditapi.infra.user.adapter.rest;

import com.creditapi.domain.common.usecase.BeanAwareUseCasePublisher;
import com.creditapi.domain.user.model.User;
import com.creditapi.domain.user.usecase.RegisterUser;
import com.creditapi.infra.user.adapter.rest.dto.RegisterUserRequest;
import com.creditapi.infra.user.adapter.rest.dto.query.RegisterUserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/register")
public class RegisterUserRestController extends BeanAwareUseCasePublisher {

    @PostMapping
    public ResponseEntity<RegisterUserResponse> register(@RequestBody @Valid RegisterUserRequest request) {
        User user = publish(User.class, request.toUseCase());
        return ResponseEntity.ok(RegisterUserResponse.from(user));
    }
}
