package com.rohit.apis.printApp.Payloads.DTOs;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StoreDTO {
    private int storeId;
    private String storeName;
    private String storeAddress;
}
