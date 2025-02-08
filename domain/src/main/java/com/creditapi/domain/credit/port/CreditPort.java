package com.creditapi.domain.credit.port;

import com.creditapi.domain.credit.model.Credit;

public interface CreditPort {
    void save(Credit credit);
}
