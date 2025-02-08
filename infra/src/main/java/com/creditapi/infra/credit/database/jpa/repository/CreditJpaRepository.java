package com.creditapi.infra.credit.database.jpa.repository;

import com.creditapi.infra.credit.database.jpa.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditJpaRepository extends JpaRepository<CreditEntity, Long> {
}
