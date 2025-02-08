package com.creditapi.infra.installment.database.jpa.entity;

import com.creditapi.domain.installment.model.Installment;
import com.creditapi.domain.installment.model.InstallmentStatus;
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
@Table(name = "installments")
@AllArgsConstructor
@NoArgsConstructor
public class InstallmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private InstallmentStatus installmentStatus;
    private BigDecimal paidAmount;
    private BigDecimal lateFee;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public static List<InstallmentEntity> fromDomain(List<Installment> installments) {
        return installments.stream()
                .map(installment -> InstallmentEntity.builder()
                        .id(installment.getId())
                        .amount(installment.getAmount())
                        .installmentStatus(installment.getInstallmentStatus())
                        .paidAmount(installment.getPaidAmount())
                        .lateFee(installment.getLateFee())
                        .build())
                .toList();
    }
}
