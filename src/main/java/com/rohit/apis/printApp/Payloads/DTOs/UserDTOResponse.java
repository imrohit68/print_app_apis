package com.rohit.apis.printApp.Payloads.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTOResponse {
    private int userId;

    private String username;

    private String name;

    private String email;

    private String mobileNumber;
}
