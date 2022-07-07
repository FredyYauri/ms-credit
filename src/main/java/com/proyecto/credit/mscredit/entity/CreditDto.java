package com.proyecto.credit.mscredit.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditDto {
    private Integer idCredit;   //id credito
    private Integer idConsumer; //id cliente
    private String typeCredit;  //tipo crédito: personal,Empresarial o tarjeta de cred
    private Float creditLine;   //valor de crédito
    private String dateDue;     //fecha de vencimiento
    private Boolean expiredDebt;
}
