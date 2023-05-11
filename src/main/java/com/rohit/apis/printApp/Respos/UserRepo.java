package com.rohit.apis.printApp.Respos;

import com.rohit.apis.printApp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    Boolean existsUserByEmailOrUsernameOrMobileNumber(String email,String username,String mobileNumber);
}