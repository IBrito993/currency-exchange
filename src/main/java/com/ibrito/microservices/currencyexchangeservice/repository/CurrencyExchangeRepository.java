package com.ibrito.microservices.currencyexchangeservice.repository;

import com.ibrito.microservices.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
   CurrencyExchange findByFromAndTo(String from, String to);
}
