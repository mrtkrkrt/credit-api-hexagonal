package com.creditapi.infra.credit.database.elastic.entity;

import com.creditapi.domain.credit.model.CreditStatus;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "credits")
public class CreditElasticDocument {

    private CreditStatus status;
    private BigDecimal amount;
    private Long userId;
}
