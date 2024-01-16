package com.ecommerce.api.controllers;

import com.ecommerce.api.dto.ApiResponse;
import com.ecommerce.api.dto.UserDto;
import com.ecommerce.api.entities.User;
import com.ecommerce.api.service.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDto userDto){
        User userCreated = userService.createUser(userDto);
        if(userCreated == null){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping
    public ApiResponse<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();

        return  new ApiResponse<>(HttpStatus.OK.value(), "All users found", users);
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);

        return new ApiResponse<>( HttpStatus.OK.value(), "user found successfully", user);
    }


}
