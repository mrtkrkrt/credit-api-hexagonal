package com.creditapi.domain.installment.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Installment {
    private Long id;
    private BigDecimal amount;
    private InstallmentStatus installmentStatus;
    private BigDecimal paidAmount;
    private BigDecimal lateFee;
}
