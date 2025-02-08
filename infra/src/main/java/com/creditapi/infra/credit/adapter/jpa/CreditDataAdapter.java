package com.creditapi.infra.credit.adapter.jpa;

import com.creditapi.domain.credit.model.Credit;
import com.creditapi.domain.credit.port.CreditPort;
import com.creditapi.infra.credit.database.jpa.entity.CreditEntity;
import com.creditapi.infra.credit.database.jpa.repository.CreditJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditDataAdapter implements CreditPort {

    private final CreditJpaRepository creditJpaRepository;

    @Override
    public void save(Credit credit) {
        creditJpaRepository.save(CreditEntity.fromDomain(credit));
    }
}
