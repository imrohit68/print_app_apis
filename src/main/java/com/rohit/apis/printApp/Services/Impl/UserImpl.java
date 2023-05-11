package com.rohit.apis.printApp.Services.Impl;

import com.rohit.apis.printApp.Entities.User;
import com.rohit.apis.printApp.Exceptions.ResourceNotFoundException;
import com.rohit.apis.printApp.Exceptions.UserAlreadyExists;
import com.rohit.apis.printApp.Payloads.DTOs.UserDTO;
import com.rohit.apis.printApp.Payloads.DTOs.UserDTOResponse;
import com.rohit.apis.printApp.Respos.UserRepo;
import com.rohit.apis.printApp.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserImpl implements UserServices {


    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    @Override
    public UserDTOResponse createUser(UserDTO user) {
        User createUser = this.modelMapper.map(user,User.class);
        String email = createUser.getEmail();
        String mobileNumber = createUser.getMobileNumber();
        String username = createUser.getUsername();
        if(!userRepo.existsUserByEmailOrUsernameOrMobileNumber(email,username,mobileNumber)){
            User returnedUser = this.userRepo.save(createUser);
            return this.modelMapper.map(returnedUser,UserDTOResponse.class);
        }
        else{
            throw new UserAlreadyExists(email,username,mobileNumber);
        }
    }

    @Override
    public UserDTOResponse updateUser(UserDTO user, int userId) {
        User getUser = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
            getUser.setName(user.getName());
            getUser.setPassword(user.getPassword());
            User savedUser = userRepo.save(getUser);
            return modelMapper.map(savedUser,UserDTOResponse.class);
    }

    @Override
    public UserDTOResponse getUserById(int userId) {
        User getUser = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
        return modelMapper.map(getUser,UserDTOResponse.class);
    }

    @Override
    public List<UserDTOResponse> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDTOResponse> userDTOS = users.stream().map(user -> this.modelMapper.map(user,UserDTOResponse.class)).collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public void deleteUser(int UserId) {
        User user = this.userRepo.findById(UserId)
                .orElseThrow(()-> new ResourceNotFoundException("user","id",UserId));
        this.userRepo.delete(user);
    }
}
