package com.creditapi.infra.credit.adapter.rest.dto.command;

import com.creditapi.domain.credit.usecase.CreateCredit;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateCreditRequest {
    private Long userId;
    private BigDecimal amount;
    private int installmentCount;

    public CreateCredit toUseCase() {
        return CreateCredit.builder()
                .userId(userId)
                .amount(amount)
                .installmentCount(installmentCount)
                .build();
    }
}
