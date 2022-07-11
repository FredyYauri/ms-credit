package com.proyecto.credit.mscredit.service;

import com.proyecto.credit.mscredit.entity.Credit;
import com.proyecto.credit.mscredit.entity.CreditDto;
import com.proyecto.credit.mscredit.events.CreditCreatedEvent;
import com.proyecto.credit.mscredit.events.Event;
import com.proyecto.credit.mscredit.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CreditEventService {
    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.credit.name:credittopic}")
    private String topicCustomer;

    public void publish(CreditDto credit) {

        CreditCreatedEvent created = new CreditCreatedEvent();
        created.setData(credit);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCustomer, created);
    }
}
