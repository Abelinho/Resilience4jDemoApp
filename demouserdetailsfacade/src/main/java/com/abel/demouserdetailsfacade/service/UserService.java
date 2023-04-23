package com.abel.demouserdetailsfacade.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import com.abel.demouserdetailsfacade.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    // private RestTemplate restTemplate;
    private WebClient webClient;

    @Retry(name = "User Retry Call", fallbackMethod = "getDefaultUser")
   public com.abel.demouserdetailsfacade.dto.UserDto getUser(int id){

        LOGGER.info("inside getUser() method");
        LOGGER.info("calling getUser with id: " + id);
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

    public com.abel.demouserdetailsfacade.dto.UserDetailsDto getUserDetails() {

        //make api calls here: annotate this method with @CircuitBreaker
//        main.java.com.abel.demouserdetailsfacade.dto.UserDetailsDto userDetails = webClient.get()
//                .uri("http://localhost:8041/api/users/" )
//                .retrieve()
//                .bodyToMono(main.java.com.abel.demouserdetailsfacade.dto.UserDetailsDto.class)
//                .block();

        //todo: configure CB pattern in application.properties file and annotation

       return null; //userDetails;
    }

    public com.abel.demouserdetailsfacade.dto.UserDto getDefaultUser(int id, Exception e){

        //todo: finish implementing this method
        LOGGER.info("inside getDefaultUser() method");

        return new UserDto("Default User","Default User");
    }
}
