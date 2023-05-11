package com.rohit.apis.printApp.Services;

import com.rohit.apis.printApp.Payloads.DTOs.StoreDTO;

import java.util.List;

public interface StoreServices {
    StoreDTO createStore(StoreDTO storeDTO);
    StoreDTO updateStore(StoreDTO storeDTO,int storeId);
    List<StoreDTO> searchStore(String address);
    List<StoreDTO> allStores();
    StoreDTO storeById(int storeId);
    void deleteStore(int storeId);
}
