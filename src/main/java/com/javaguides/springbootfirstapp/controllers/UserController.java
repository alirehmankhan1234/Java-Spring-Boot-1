package com.javaguides.springbootfirstapp.controllers;

import com.javaguides.springbootfirstapp.models.AuthRequest;
import com.javaguides.springbootfirstapp.models.UserInfo;
import com.javaguides.springbootfirstapp.service.JwtService;
import com.javaguides.springbootfirstapp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Security tutorials";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        return userInfoService.addUser(userInfo);
    }

    @PostMapping("/login")
    public String addUser(@RequestBody AuthRequest authRequest){
        System.out.println(authRequest.getUserName()+" "+authRequest.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUserName());
        }else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }

    @GetMapping("/getUsers")
    public List<UserInfo> getAllUser(){
        return userInfoService.getAllUser();
    }

    @GetMapping("/getUsers/{id}")
    public UserInfo getUser(@PathVariable Integer id){
        return userInfoService.getUser(id);
    }


}
