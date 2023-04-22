package com.abel.demoretrypattern.service;

import com.abel.demoretrypattern.dto.UserDto;
import org.springframework.stereotype.Service;
//import main.java.com.abel.demoretrypattern.dto.UserDto;

@Service
public class UserserviceImpl implements com.abel.demoretrypattern.service.UserService {
    @Override
    public UserDto getUser(int userId) {
        return new UserDto("Abel","Leo");
    }
}
