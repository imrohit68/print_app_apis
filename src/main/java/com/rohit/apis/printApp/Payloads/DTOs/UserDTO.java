package com.rohit.apis.printApp.Payloads.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int userId;
    @NotEmpty
    private String username;
    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String mobileNumber;
}
