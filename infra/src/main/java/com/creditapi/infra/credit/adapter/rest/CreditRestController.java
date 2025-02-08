package com.creditapi.infra.credit.adapter.rest;

import com.creditapi.domain.common.usecase.BeanAwareUseCasePublisher;
import com.creditapi.infra.credit.adapter.rest.dto.command.CreateCreditRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credits")
public class CreditRestController extends BeanAwareUseCasePublisher {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> initializeCredit(@RequestBody @Valid CreateCreditRequest request) {
        publish(request.toUseCase());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
