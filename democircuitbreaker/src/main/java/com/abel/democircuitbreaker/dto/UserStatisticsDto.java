package com.abel.democircuitbreaker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class UserStatisticsDto {
    private int timeSpentInSeconds;

    private Date lastLoggedIn;
}
