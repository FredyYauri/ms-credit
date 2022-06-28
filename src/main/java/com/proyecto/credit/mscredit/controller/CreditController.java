package com.proyecto.credit.mscredit.controller;

import com.proyecto.credit.mscredit.entity.Credit;
import com.proyecto.credit.mscredit.service.CreditService;
import com.proyecto.credit.mscredit.service.CreditServiceImpl;
import io.netty.util.internal.shaded.org.jctools.queues.MpscUnboundedArrayQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credit")
@Slf4j
public class CreditController {
    @Autowired
    private CreditService creditService;

    @GetMapping
    public Flux<Credit> getAll() {
        return creditService.getAll();
    }

    @GetMapping("/byCustomer/{idCustomer}")
    public Flux<Credit> getByCustomerID(@PathVariable Integer idCustomer) {
        log.info("INI getByCustomerID: idCustomer " + idCustomer);
        return creditService.getByCustomerID(idCustomer);
    }

    @PostMapping
    public Mono<Credit> saveCredit(@RequestBody Credit credit) {
        return creditService.saveCredit(credit);
    }

    @PutMapping
    public Mono<Credit> updateCredit(@RequestBody Credit credit) {
        return creditService.updateCredit(credit);
    }

    @DeleteMapping("/{id}")
    public Mono<Credit> deleteCredit(@PathVariable Integer id) {
        return creditService.deleteCredit(id);
    }
}
