package com.gihanz.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data()
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
//    @JsonIgnore
    private String password;

    @JsonIgnore()
    public User getEntity(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }
}
