package com.abel.demouserdetailsfacade.dto;

import com.abel.demouserdetailsfacade.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    private UserDto user;
    private com.abel.demouserdetailsfacade.dto.UserStatisticsDto statistics;
}
