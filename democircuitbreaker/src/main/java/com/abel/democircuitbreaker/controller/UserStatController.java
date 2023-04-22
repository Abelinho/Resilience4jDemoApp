package com.abel.democircuitbreaker.controller;

import com.abel.democircuitbreaker.Service.UserStatisticsService;
import com.abel.democircuitbreaker.dto.UserStatisticsDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
//@AllArgsConstructor
public class UserStatController {

    @Autowired
    private UserStatisticsService userStatisticsService;

    @GetMapping("/userStats/{id}")
    public UserStatisticsDto getUserStat(@PathVariable int id){

        return userStatisticsService.getStatistics(id);
    }
}
