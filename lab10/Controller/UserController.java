package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.User;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addAllUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
       userService.addAllUsers(user);
        return ResponseEntity.status(200).body(new ApiResponse("Success"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isTrue= userService.updateUser(id,user);
        if(isTrue){
            return ResponseEntity.status(200).body(new ApiResponse("Updated is Success"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Valid:The user not Exist"));
    }
    @DeleteMapping("/delete/{id}")
     public ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isTrue=userService.deleteuser(id);
        if(isTrue){
            return ResponseEntity.status(200).body(new ApiResponse("deleted is Success"));
        }
         return ResponseEntity.status(400).body(new ApiResponse("Valid:The user not Exist"));
     }

}

