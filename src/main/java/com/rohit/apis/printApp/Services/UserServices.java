package com.rohit.apis.printApp.Services;

import com.rohit.apis.printApp.Payloads.DTOs.UserDTO;
import com.rohit.apis.printApp.Payloads.DTOs.UserDTOResponse;

import java.util.List;

public interface UserServices {
    UserDTOResponse createUser(UserDTO user);
    UserDTOResponse updateUser(UserDTO user,int userId);
    UserDTOResponse getUserById(int userId);
    List<UserDTOResponse> getAllUsers();
    void deleteUser(int UserId);
}
