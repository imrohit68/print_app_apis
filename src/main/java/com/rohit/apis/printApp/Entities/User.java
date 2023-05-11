package com.rohit.apis.printApp.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String username;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    @OneToMany(mappedBy = "user")
    private List<Request> posts = new ArrayList<>();
}
