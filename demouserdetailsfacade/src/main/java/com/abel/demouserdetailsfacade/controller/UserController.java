package com.abel.demouserdetailsfacade.controller;

import com.abel.demouserdetailsfacade.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/user/{id}")
    public com.abel.demouserdetailsfacade.dto.UserDto getUser(@PathVariable int id){

        return userService.getUser(id);
    }

    public com.abel.demouserdetailsfacade.dto.UserDetailsDto getUserdetails(){

        return userService.getUserDetails();
    }

}
