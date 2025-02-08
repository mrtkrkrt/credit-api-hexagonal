package com.creditapi.infra.credit.database.jpa.entity;

import com.creditapi.domain.credit.model.Credit;
import com.creditapi.domain.credit.model.CreditStatus;
import com.creditapi.infra.installment.database.jpa.entity.InstallmentEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "credits")
@AllArgsConstructor
@NoArgsConstructor
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CreditStatus status;
    private BigDecimal amount;
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InstallmentEntity> installments;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;


    public static CreditEntity fromDomain(Credit credit) {
        return CreditEntity.builder()
                .id(credit.getId())
                .status(credit.getStatus())
                .amount(credit.getAmount())
                .userId(credit.getUserId())
                .installments(InstallmentEntity.fromDomain(credit.getInstallments()))
                .build();
    }
}
