package com.ziphiro.websocketChat.dto;


import com.ziphiro.websocketChat.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserRegistrationDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;

}
