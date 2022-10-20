package com.gihanz.services;

import com.gihanz.dtos.LoginResponseDTO;
import com.gihanz.dtos.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO dto);

    LoginResponseDTO systemLogin(UserDTO dto);

}
