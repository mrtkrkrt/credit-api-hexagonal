package com.creditapi.domain.credit;

import com.creditapi.domain.common.usecase.DomainComponent;
import com.creditapi.domain.common.usecase.ObservableUseCasePublisher;
import com.creditapi.domain.common.usecase.VoidUseCaseHandler;
import com.creditapi.domain.credit.model.Credit;
import com.creditapi.domain.credit.port.CreditPort;
import com.creditapi.domain.credit.usecase.CreateCredit;
import com.creditapi.domain.user.usecase.RetrieveUser;

@DomainComponent
public class CreateCreditUseCaseHandler extends ObservableUseCasePublisher implements VoidUseCaseHandler<CreateCredit> {

    private final CreditPort creditPort;

    public CreateCreditUseCaseHandler(CreditPort creditPort) {
        this.creditPort = creditPort;
        register(CreateCredit.class, this);
    }

    @Override
    public void handle(CreateCredit useCase) {
        publish(new RetrieveUser(useCase.userId()));
        Credit credit = useCase.createCredit();
        creditPort.save(credit);
    }
}
