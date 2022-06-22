package com.proyecto.credit.mscredit.service;

import com.proyecto.credit.mscredit.entity.Credit;
import com.proyecto.credit.mscredit.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Flux<Credit> getAll() {
        return creditRepository.findAll();
    }

    @Override
    public Mono<Credit> saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public Mono<Credit> updateCredit(Credit credit) {
        return creditRepository.findById(credit.getIdCredit())
                .flatMap(newCredit -> {
                    newCredit.setCreditLine(credit.getCreditLine());
                    newCredit.setTypeCredit(credit.getTypeCredit());
                    newCredit.setDateDue(credit.getDateDue());
                    newCredit.setIdConsumer(credit.getIdConsumer());
                    return creditRepository.save(newCredit);
                });
    }

    @Override
    public Mono<Credit> deleteCredit(Integer idCredit) {
        return creditRepository.findById(idCredit)
                .flatMap(creditDelete ->  creditRepository.delete(creditDelete).then(Mono.just(creditDelete)));
    }
}
