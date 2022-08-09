package com.ibrito.microservices.currencyexchangeservice.controller;

import com.ibrito.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.ibrito.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
@Slf4j
public class CurrencyExchangeController {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Value("${server.port}")
    String port;


    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveValue(@PathVariable String from, @PathVariable String to) {

        log.info("retrieveValue called with {} {}", from, to);

        var response = currencyExchangeRepository.findByFromAndTo(from, to);
        response.setEnvironment(port);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
