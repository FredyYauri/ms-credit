package com.proyecto.credit.mscredit.service;

import com.proyecto.credit.mscredit.entity.Credit;
import com.proyecto.credit.mscredit.entity.CreditDto;
import com.proyecto.credit.mscredit.repository.CreditRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CreditServiceImpl implements CreditService {
    @Autowired
    private CreditRepository creditRepository;
    private final ModelMapper mapper = new ModelMapper();

    /**
     * Método encargado de obtener todas las cuentas de crédito
     *
     * @return lista de cuentas de crédito
     */
    @Override
    public Flux<CreditDto> getAllCredit() {
        log.info("Ingresa al getAllCredit");
        return creditRepository.findAll().map(credit -> mapToCreditModel(credit));
    }

    /**
     * Método encargado de obtener las cuentas de crédito de un cliente
     *
     * @param idCustomer id del cliente
     * @return lista de cuentas de crédito
     */
    @Override
    public Flux<CreditDto> getByCustomerID(Integer idCustomer) {
        log.info("INI impl getByCustomerID: idCustomer " + idCustomer);
        return creditRepository.findAll().filter(credits ->
                credits.getIdConsumer().equals(idCustomer)
        ).map(credit -> mapToCreditModel(credit));
    }

    /**
     * Método encargado de registrar la información de un de la cuenta de crédito nuevo
     *
     * @param credit objeto con los datos de la cuenta de crédito
     * @return retirna el objeto creado
     */
    @Override
    public Mono<CreditDto> saveCredit(Credit credit) {
        return creditRepository.save(credit).map(cre -> mapToCreditModel(cre));
    }

    /**
     * Método encargado de modificar la información de una cuenta de crédito
     *
     * @param credit objeto que contiene la información de la cuenta de crédito
     * @return retorna el objeto modificado
     */
    @Override
    public Mono<CreditDto> updateCredit(Credit credit) {
        return creditRepository.findById(credit.getIdCredit())
                .flatMap(newCredit -> {
                    newCredit.setCreditLine(credit.getCreditLine());
                    newCredit.setTypeCredit(credit.getTypeCredit());
                    newCredit.setDateDue(credit.getDateDue());
                    newCredit.setIdConsumer(credit.getIdConsumer());
                    return creditRepository.save(newCredit).map(cre -> mapToCreditModel(cre));
                });
    }

    /**
     * Método encargado de obtener la información de una cuenta de crédito
     *
     * @param idCredit id de la cuenta de crédito
     * @return retorna la cuenta buscada
     */
    @Override
    public Mono<CreditDto> deleteCredit(Integer idCredit) {
        return creditRepository.findById(idCredit)
                .flatMap(creditDelete ->
                        creditRepository.delete(creditDelete).then(Mono.just(mapToCreditModel(creditDelete))));
    }


    /**
     * Método utilizado para mapear los parámetros del entity al dto
     *
     * @param credit Credit entity
     * @return credit dto
     */
    private CreditDto mapToCreditModel(Credit credit) {
        log.info("Ingresa al mapToCreditModel");
        return mapper.map(credit, CreditDto.class);
    }
}
