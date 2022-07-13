package com.ibrito.microservices.currencyexchangeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class CurrencyExchange {
    @Id
    Long id;
    @Column(name="currency_from")
    String from;
    @Column(name="currency_to")
    String to;
    BigDecimal conversionMultiple;

   @Transient
    String environment;
}
