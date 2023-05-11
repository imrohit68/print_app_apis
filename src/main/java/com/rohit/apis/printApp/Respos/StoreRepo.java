package com.rohit.apis.printApp.Respos;

import com.rohit.apis.printApp.Entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepo extends JpaRepository<Store,Integer> {
    List<Store> findStoresByStoreAddressContaining(String address);
}
