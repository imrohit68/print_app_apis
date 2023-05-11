package com.rohit.apis.printApp.Controllers;

import com.rohit.apis.printApp.Payloads.Responses.ApiResponse;
import com.rohit.apis.printApp.Payloads.DTOs.UserDTO;
import com.rohit.apis.printApp.Payloads.DTOs.UserDTOResponse;
import com.rohit.apis.printApp.Services.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserServices userServices;
    @PostMapping("/createUser")
    public ResponseEntity<UserDTOResponse> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTOResponse createdUser = this.userServices.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDTOResponse> updateUser(@Valid @RequestBody UserDTO userDTO ,@PathVariable int userId){
        UserDTOResponse updateUser = this.userServices.updateUser(userDTO,userId);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDTOResponse> getUserById(@PathVariable int userId){
        UserDTOResponse userDTO = this.userServices.getUserById(userId);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDTOResponse>> getAllUser(){
        List<UserDTOResponse> userDTOS = this.userServices.getAllUsers();
        return new ResponseEntity<>(userDTOS,HttpStatus.OK);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId){
        this.userServices.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("UserDeleted",true),HttpStatus.OK);
    }

}
