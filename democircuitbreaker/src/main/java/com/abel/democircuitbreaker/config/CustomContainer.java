package com.abel.democircuitbreaker.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {//extends AbstractConfigurableWebServerFactory

        @Override
        public void customize(ConfigurableServletWebServerFactory factory){
          factory.setPort(8042);//you can do this in properties/yml too
        }

//    @Override
//    public void setPort(int port) {
//        super.setPort(port);
//    }

}

