package com.example.demo.service;

import com.example.demo.dto.UserDTo;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Transactional

public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTo> getAllUsers(){
        List<User>userList =userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTo>>(){}.getType());
    }

    public UserDTo getUserById(Integer userId){
        User user = userRepo.getUserById(userId);
        return modelMapper.map(user,UserDTo.class);
    }

    public UserDTo saveUser(UserDTo userDTo){
        userRepo.save(modelMapper.map(userDTo,User.class));
        return userDTo;
    }

    public UserDTo updateUser(UserDTo userDTo){
        userRepo.save(modelMapper.map(userDTo,User.class));
        return  userDTo;
    }

    public String deleteUser(UserDTo userDTo){
        userRepo.delete(modelMapper.map(userDTo,User.class));
        return "User deleted";
    }

    public String deleteUser_u(Integer userId){
        userRepo.deleteById(userId);
        return "User deleted";
    }

}
