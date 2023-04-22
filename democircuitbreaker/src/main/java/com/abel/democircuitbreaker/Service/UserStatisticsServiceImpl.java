package com.abel.democircuitbreaker.Service;

import com.abel.democircuitbreaker.dto.UserStatisticsDto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserStatisticsServiceImpl implements com.abel.democircuitbreaker.Service.UserStatisticsService {
    @Override
    public UserStatisticsDto getStatistics(int userId) {

        return new UserStatisticsDto(5, new Date());
    }
}
