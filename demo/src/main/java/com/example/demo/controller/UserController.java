package com.example.demo.controller;

import com.example.demo.dto.UserDTo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getusers")

    public List<UserDTo> getUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userid}")
        public UserDTo getUserById(@PathVariable Integer userid){
        return userService.getUserById(userid);
    }


    @PostMapping("/adduser")
    public UserDTo saveUser(@RequestBody UserDTo userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateuser")
    public UserDTo updateuser(@RequestBody UserDTo userDTo){
        return userService.updateUser(userDTo);
    }

    @DeleteMapping("/deleteuser")
    public String deleteuser(@RequestBody UserDTo userDTo){
        return userService.deleteUser(userDTo);
    }

    @DeleteMapping("deleteuser_u/{userid}")
    public String deleteuser_u(@PathVariable Integer userid){
        return userService.deleteUser_u(userid);
    }
}
