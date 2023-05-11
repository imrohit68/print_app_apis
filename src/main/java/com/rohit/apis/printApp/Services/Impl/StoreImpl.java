package com.rohit.apis.printApp.Services.Impl;

import com.rohit.apis.printApp.Entities.Store;
import com.rohit.apis.printApp.Exceptions.ResourceNotFoundException;
import com.rohit.apis.printApp.Payloads.DTOs.StoreDTO;
import com.rohit.apis.printApp.Respos.StoreRepo;
import com.rohit.apis.printApp.Services.StoreServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreImpl implements StoreServices {
    private final ModelMapper modelMapper;
    private final StoreRepo storeRepo;
    @Override
    public StoreDTO createStore(StoreDTO storeDTO) {
        Store store = modelMapper.map(storeDTO,Store.class);
        Store savedStore = this.storeRepo.save(store);
        return modelMapper.map(savedStore, StoreDTO.class);
    }

    @Override
    public StoreDTO updateStore(StoreDTO storeDTO, int storeId) {
        Store store = this.storeRepo.findById(storeId)
                .orElseThrow(()-> new ResourceNotFoundException("Store","id",storeId));
        store.setStoreAddress(storeDTO.getStoreAddress());
        store.setStoreName(storeDTO.getStoreName());
        Store updatedStore = this.storeRepo.save(store);
        return modelMapper.map(updatedStore, StoreDTO.class);
    }

    @Override
    public List<StoreDTO> searchStore(String address) {
        List<Store> stores = this.storeRepo.findStoresByStoreAddressContaining(address);
        List<StoreDTO> storeDTOS = stores.stream().map(store -> modelMapper.map(store, StoreDTO.class)).collect(Collectors.toList());
        return storeDTOS;
    }

    @Override
    public List<StoreDTO> allStores() {
        List<Store> stores = this.storeRepo.findAll();
        List<StoreDTO> storeDTOS = stores.stream().map(store -> modelMapper.map(store, StoreDTO.class)).collect(Collectors.toList());
        return storeDTOS;
    }

    @Override
    public StoreDTO storeById(int storeId) {
        Store store = this.storeRepo.findById(storeId)
                .orElseThrow(()-> new ResourceNotFoundException("Store","id",storeId));
        return modelMapper.map(store, StoreDTO.class);
    }

    @Override
    public void deleteStore(int storeId) {
        Store store = this.storeRepo.findById(storeId).orElseThrow(()->new ResourceNotFoundException("store","id",storeId));
        this.storeRepo.delete(store);
    }
}
