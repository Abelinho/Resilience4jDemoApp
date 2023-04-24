package com.abel.demouserdetailsfacade.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CustomCircuitBreaker {

    // Create a custom configuration for a CircuitBreaker
    CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(50)
            .minimumNumberOfCalls(5)
            .waitDurationInOpenState(Duration.ofMillis(5000))
            .permittedNumberOfCallsInHalfOpenState(2)
            .automaticTransitionFromOpenToHalfOpenEnabled(true)
            .slidingWindowSize(10)
            .build();

    // Create a CircuitBreakerRegistry with a custom global configuration
    CircuitBreakerRegistry circuitBreakerRegistry =
            CircuitBreakerRegistry.of(circuitBreakerConfig);

    // Get or create a CircuitBreaker from the CircuitBreakerRegistry
// with a custom configuration
    CircuitBreaker circuitBreakerWithCustomConfig = circuitBreakerRegistry
            .circuitBreaker("userDetailsCB", circuitBreakerConfig);

}
