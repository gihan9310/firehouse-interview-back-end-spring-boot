package com.gihanz.services.impl;

import com.gihanz.dtos.LoginResponseDTO;
import com.gihanz.dtos.UserDTO;
import com.gihanz.entities.User;
import com.gihanz.exceptions.UnauthorizedLoginException;
import com.gihanz.repositories.UserRepository;
import com.gihanz.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional()
    @Override
    public UserDTO createUser(UserDTO dto) {
        try {
            User user = this.userRepository.save(dto.getEntity());
            return user.getDto();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("exception : "+e.getMessage());
        }
        return null;
    }

    @Override
    public LoginResponseDTO systemLogin(UserDTO dto) {
        try {
            User user = this.userRepository.findByUsername(dto.getUsername());
            if(user==null){
                throw new UnauthorizedLoginException("Invalid username or password");
            }
            if(!user.getPassword().equals(dto.getPassword())){
                throw new UnauthorizedLoginException("Invalid username or password");
            }
            return new LoginResponseDTO(user.getId(),user.getUsername(),true);
        } catch (UnauthorizedLoginException e) {
//            e.printStackTrace();
            log.error("username : "+dto.getUsername() +" not found");
            throw new UnauthorizedLoginException(e.getMessage());
        }
    }
}
