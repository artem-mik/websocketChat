package com.ziphiro.websocketChat.controller;

import com.ziphiro.websocketChat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity <String> registerUser(@RequestBody UserRegistrationDto userDto){
//            try{
//                User user = User.builder().name(userDto.getName()).email(userDto.getEmail())
//                        .password(userDto.getPassword()).role(Role.USER).build();
//                userService.registerUser(user);
//                return ResponseEntity.ok("registration success");
//            } catch (RuntimeException e){
//                return ResponseEntity.badRequest().body(e.getMessage());
//            }
//    }
}
