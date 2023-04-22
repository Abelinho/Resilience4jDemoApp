package com.abel.demoretrypattern.controller;

import com.abel.demoretrypattern.dto.UserDto;
import com.abel.demoretrypattern.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
//@AllArgsConstructor
public class Usercontroller {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserDto getUsers(@PathVariable int id){

        return userService.getUser(id);
    }

}
