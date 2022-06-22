package com.proyecto.credit.mscredit.service;

import com.proyecto.credit.mscredit.entity.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Flux<Credit> getAll();
    Mono<Credit> saveCredit(Credit credit);
    Mono<Credit> updateCredit(Credit credit);
    Mono<Credit> deleteCredit(Integer idCredit);
}
