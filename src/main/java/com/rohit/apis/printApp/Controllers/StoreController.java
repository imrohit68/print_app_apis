package com.rohit.apis.printApp.Controllers;

import com.rohit.apis.printApp.Entities.Store;
import com.rohit.apis.printApp.Payloads.DTOs.StoreDTO;
import com.rohit.apis.printApp.Payloads.Responses.ApiResponse;
import com.rohit.apis.printApp.Services.StoreServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/store")
public class StoreController {
    private final StoreServices storeServices;
    @PostMapping("/createStore")
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO){
        StoreDTO storeDTO1 = this.storeServices.createStore(storeDTO);
        return new ResponseEntity<>(storeDTO1, HttpStatus.OK);
    }
    @PutMapping("updateStore/{storeId}")
    public ResponseEntity<StoreDTO> updateStore(@RequestBody StoreDTO storeDTO,@PathVariable int storeId){
        StoreDTO storeDTO1 = this.storeServices.updateStore(storeDTO,storeId);
        return new ResponseEntity<>(storeDTO1,HttpStatus.OK);
    }
    @GetMapping("getStoreByAddress/{storeAddress}")
    public ResponseEntity<List<StoreDTO>> getStoresByAddress (@PathVariable String storeAddress){
        List<StoreDTO> storeDTOS = this.storeServices.searchStore(storeAddress);
        return new ResponseEntity<>(storeDTOS,HttpStatus.OK);
    }
    @GetMapping("getStoreById/{storeId}")
    public ResponseEntity<StoreDTO> getStoreById (@PathVariable int storeId){
        StoreDTO storeDTO = this.storeServices.storeById(storeId);
        return new ResponseEntity<>(storeDTO,HttpStatus.OK);
    }
    @GetMapping("getAllStores")
    public ResponseEntity<List<StoreDTO>> getAllStores(){
        List<StoreDTO> storeDTOS = this.storeServices.allStores();
        return new ResponseEntity<>(storeDTOS,HttpStatus.OK);
    }
    @DeleteMapping("deleteStore/{storeId}")
    public ResponseEntity<ApiResponse> deleteStore(@PathVariable int storeId){
        this.storeServices.deleteStore(storeId);
        return new ResponseEntity<>(new ApiResponse("Deleted Successfully",true),HttpStatus.OK);
    }
}
