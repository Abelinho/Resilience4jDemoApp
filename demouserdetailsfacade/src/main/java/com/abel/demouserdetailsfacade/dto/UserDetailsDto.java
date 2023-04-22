package main.java.com.abel.demouserdetailsfacade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDetailsDto {
    private UserDto user;
    private UserStatisticsDto statistics;
}
