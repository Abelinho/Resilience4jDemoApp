//package com.abel.demouserdetailsfacade.config;
//
//import io.github.resilience4j.retry.RetryRegistry;
//import org.springframework.boot.actuate.health.AbstractHealthIndicator;
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CustomRetryHealthIndicator extends AbstractHealthIndicator {
//
//    private final RetryRegistry retryRegistry;
//
//    public CustomRetryHealthIndicator(RetryRegistry retryRegistry) {
//        this.retryRegistry = retryRegistry;
//    }
//
//    @Override
//    protected void doHealthCheck(Health.Builder builder) throws Exception {
//        //you can programmatically configure retry pattern here
//    }
//}
