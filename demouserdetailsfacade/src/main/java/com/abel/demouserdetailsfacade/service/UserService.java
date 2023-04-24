package com.abel.demouserdetailsfacade.service;

import com.abel.demouserdetailsfacade.dto.UserDetailsDto;
import com.abel.demouserdetailsfacade.dto.UserStatisticsDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import com.abel.demouserdetailsfacade.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;

@Service
@AllArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    // private RestTemplate restTemplate;
    private WebClient webClient;

    @Retry(name = "User Retry Call", fallbackMethod = "getDefaultUser")
   public com.abel.demouserdetailsfacade.dto.UserDto getUser(int id){

        LOGGER.info("inside getUser() method");
       //make api calls here: annotate this method with @CircuitBreaker

//               ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://localhost:8041/api/users/" + id,
//                       com.abel.demouserdetailsfacade.dto.UserDto.class);
//
//        UserDto userDto = responseEntity.getBody();

       com.abel.demouserdetailsfacade.dto.UserDto userDto = webClient.get()
               .uri("http://localhost:8041/api/users/" + id)
               .retrieve()//initiates retrieval of the response body
               .bodyToMono(com.abel.demouserdetailsfacade.dto.UserDto.class)//specify the type of response body
               .block();//makes a synchronous, blocking call to the request and waits for the response

 //todo: configure retry pattern in application.properties file and annotation?
       return userDto;
    }

    @CircuitBreaker(name = "userDetailsCB", fallbackMethod = "getDefaultUserDetails")
    public com.abel.demouserdetailsfacade.dto.UserStatisticsDto getUserDetails(int id) {

        LOGGER.info("inside getUserDetails() method");

        //make api calls here: annotate this method with @CircuitBreaker
        com.abel.demouserdetailsfacade.dto.UserStatisticsDto userDetails = webClient.get()
                .uri("http://localhost:8042/api/userStats/"+id )
                .retrieve()
                .bodyToMono(com.abel.demouserdetailsfacade.dto.UserStatisticsDto.class)
                .block();

        //todo: configure CB pattern in application.properties file and annotation

       return userDetails;
    }

    public com.abel.demouserdetailsfacade.dto.UserDto getDefaultUser(int id, Exception e){

        //todo: finish implementing this method
        LOGGER.info("inside getDefaultUser() method");

        return new UserDto("Default User","Default User");
    }

    public UserStatisticsDto getDefaultUserDetails(int id, Exception e){

        LOGGER.info("inside getDefaultUserDetails() method");

        return  new UserStatisticsDto(3,new Date(2020,12,12));
    }
}
