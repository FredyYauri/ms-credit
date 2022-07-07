package com.proyecto.credit.mscredit.controller;

import com.proyecto.credit.mscredit.entity.Credit;
import com.proyecto.credit.mscredit.entity.CreditDto;
import com.proyecto.credit.mscredit.service.CreditService;
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

    /**
     * Método encargado de obtener todas las cuentas de crédito
     *
     * @return lista de cuentas de crédito
     */
    @GetMapping
    public Flux<CreditDto> getAll() {
        return creditService.getAllCredit();
    }

    /**
     * Método encargado de obtener las cuentas de crédito de un cliente
     *
     * @param idCustomer id del cliente
     * @return lista de cuentas de crédito
     */
    @GetMapping("/bycustomer/{idCustomer}")
    public Flux<CreditDto> getByCustomerID(@PathVariable Integer idCustomer) {
        log.info("INI getByCustomerID: idCustomer " + idCustomer);
        return creditService.getByCustomerID(idCustomer);
    }

    /**
     * Método encargado de registrar la información de un de la cuenta de crédito nuevo
     *
     * @param credit objeto con los datos de la cuenta de crédito
     * @return retirna el objeto creado
     */
    @PostMapping
    public Mono<CreditDto> saveCredit(@RequestBody Credit credit) {
        return creditService.saveCredit(credit);
    }

    /**
     * Método encargado de modificar la información de una cuenta de crédito
     *
     * @param credit objeto que contiene la información de la cuenta de crédito
     * @return retorna el objeto modificado
     */
    @PutMapping
    public Mono<CreditDto> updateCredit(@RequestBody Credit credit) {
        return creditService.updateCredit(credit);
    }

    /**
     * Método encargado de obtener la información de una cuenta de crédito
     *
     * @param idCredit id de la cuenta de crédito
     * @return retorna la cuenta buscada
     */
    @DeleteMapping("/{idCredit}")
    public Mono<CreditDto> deleteCredit(@PathVariable Integer idCredit) {
        return creditService.deleteCredit(idCredit);
    }
}
