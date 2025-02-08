package com.creditapi.domain.credit.model;

import com.creditapi.domain.installment.model.Installment;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Credit {
    private Long id;
    private CreditStatus status;
    private BigDecimal amount;
    private Long userId;
    private List<Installment> installments;
}
