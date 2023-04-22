package com.abel.demoretrypattern.service;

import com.abel.demoretrypattern.dto.UserDto;

public interface UserService {
    UserDto getUser(int userId);
}
