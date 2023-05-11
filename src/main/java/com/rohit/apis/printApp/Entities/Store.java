package com.rohit.apis.printApp.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int storeId;
    private String storeName;
    private String storeAddress;
    @OneToMany
    private List<Request> requests;
}
