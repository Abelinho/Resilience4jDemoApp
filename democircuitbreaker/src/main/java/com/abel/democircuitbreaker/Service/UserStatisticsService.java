package com.abel.democircuitbreaker.Service;

import com.abel.democircuitbreaker.dto.UserStatisticsDto;

public interface UserStatisticsService {
    UserStatisticsDto getStatistics(int userId);
}
