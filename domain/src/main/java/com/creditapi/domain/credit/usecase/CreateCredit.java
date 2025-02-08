package com.creditapi.domain.credit.usecase;

import com.creditapi.domain.common.usecase.UseCase;
import com.creditapi.domain.credit.model.Credit;
import com.creditapi.domain.credit.model.CreditStatus;
import com.creditapi.domain.installment.model.Installment;
import com.creditapi.domain.installment.model.InstallmentStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Builder
public record CreateCredit(
        Long userId,
        BigDecimal amount,
        int installmentCount
) implements UseCase {
    public Credit createCredit() {
        return Credit.builder()
                .userId(userId)
                .amount(amount)
                .status(CreditStatus.ACTIVE)
                .installments(createInstallments())
                .build();
    }

    private List<Installment> createInstallments() {
        BigDecimal installmentAmount = amount.divide(BigDecimal.valueOf(installmentCount), 2, RoundingMode.HALF_UP);
        return IntStream.range(0, installmentCount)
                .mapToObj(i -> Installment.builder()
                        .amount(installmentAmount)
                        .installmentStatus(InstallmentStatus.UNPAID)
                        .build())
                .collect(Collectors.toList());
    }
}
