package com.proyecto.credit.mscredit.service;

import com.proyecto.credit.mscredit.entity.Credit;
import com.proyecto.credit.mscredit.entity.CreditDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Flux<CreditDto> getAllCredit();

    Mono<CreditDto> saveCredit(Credit credit);

    Mono<CreditDto> updateCredit(Credit credit);

    Mono<CreditDto> deleteCredit(Integer idCredit);

    Flux<CreditDto> getByCustomerID(Integer idCustomer);

}
