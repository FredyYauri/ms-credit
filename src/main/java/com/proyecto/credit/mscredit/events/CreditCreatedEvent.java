package com.proyecto.credit.mscredit.events;

import com.proyecto.credit.mscredit.entity.CreditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditCreatedEvent extends Event<CreditDto> {

}
