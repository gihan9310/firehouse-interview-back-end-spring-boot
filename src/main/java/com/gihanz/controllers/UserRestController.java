package com.gihanz.controllers;

import com.gihanz.dtos.LoginResponseDTO;
import com.gihanz.dtos.UserDTO;
import com.gihanz.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
@CrossOrigin()
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "register")
    public ResponseEntity<UserDTO> registerNewUser(@RequestBody UserDTO dto){
        UserDTO user = this.userService.createUser(dto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody UserDTO dto){
        LoginResponseDTO login = this.userService.systemLogin(dto);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
}
