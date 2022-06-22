package com.proyecto.credit.mscredit.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "credits")
public class Credit {
    @Id
    private Integer idCredit;   //id credito
    private Integer idConsumer; //id cliente
    private String typeCredit;  //tipo crédito: personal,Empresarial o tarjeta de cred
    private Float creditLine;   //valor de crédito
    private String dateDue;     //fecha de vencimiento
}
