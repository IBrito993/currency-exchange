package com.ibrito.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/circuit-breaker")
@RequiredArgsConstructor
@Slf4j
public class CircuitBreakerController {


    @GetMapping
    //@Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
    //@CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
    //@RateLimiter(name="default")
    @Bulkhead(name = "sample-api")
    public ResponseEntity<String> retrieveValue() {
        log.info("Sample API call received");

        //return new RestTemplate().getForEntity("http://localhost:9999/dummy", String.class);
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Response");
    }

    private ResponseEntity<String> hardcodedResponse(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Fallback");
    }

}
