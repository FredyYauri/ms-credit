package com.proyecto.credit.mscredit.controller;

import com.proyecto.credit.mscredit.entity.Credit;
import com.proyecto.credit.mscredit.service.CreditService;
import com.proyecto.credit.mscredit.service.CreditServiceImpl;
import io.netty.util.internal.shaded.org.jctools.queues.MpscUnboundedArrayQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credit")
public class CreditController {
    @Autowired
    private CreditService creditService;

    @GetMapping
    public Flux<Credit> getAll(){
        return creditService.getAll();
    }

    @PostMapping
    public Mono<Credit> saveCredit(@RequestBody Credit credit){
        return creditService.saveCredit(credit);
    }

    @PutMapping
    public Mono<Credit> updateCredit(@RequestBody Credit credit){
        return creditService.updateCredit(credit);
    }

    @DeleteMapping("/{id}")
    public Mono<Credit> deleteCredit(@PathVariable Integer id){
        return creditService.deleteCredit(id);
    }
}
