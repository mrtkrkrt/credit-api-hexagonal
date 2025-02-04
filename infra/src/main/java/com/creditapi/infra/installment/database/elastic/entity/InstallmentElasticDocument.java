package com.creditapi.infra.installment.database.elastic.entity;

import com.creditapi.domain.installment.model.InstallmentStatus;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "installments")
public class InstallmentElasticDocument {
    private Long creditId;
    private BigDecimal amount;
    private InstallmentStatus installmentStatus;
    private BigDecimal paidAmount;
    private BigDecimal lateFee;
}
