package com.rohit.apis.printApp.Respos;

import com.rohit.apis.printApp.Entities.Request;
import com.rohit.apis.printApp.Entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request,Integer> {
    List<Request> findByStoreStoreId(int storeId);
}
