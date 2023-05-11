package com.rohit.apis.printApp.Services.Impl;

import com.rohit.apis.printApp.Entities.Request;
import com.rohit.apis.printApp.Entities.Store;
import com.rohit.apis.printApp.Entities.User;
import com.rohit.apis.printApp.Exceptions.ResourceNotFoundException;
import com.rohit.apis.printApp.Payloads.DTOs.RequestDTO;
import com.rohit.apis.printApp.Respos.RequestRepo;
import com.rohit.apis.printApp.Respos.StoreRepo;
import com.rohit.apis.printApp.Respos.UserRepo;
import com.rohit.apis.printApp.Services.RequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RequestImpl implements RequestService {
    private final RequestRepo requestRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final StoreRepo storeRepo;

    @Override
    public RequestDTO createRequest(RequestDTO requestDTO,int userId,int storeId) {
        Request request = modelMapper.map(requestDTO,Request.class);
        User user = userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
        Store store = this.storeRepo.findById(storeId)
                .orElseThrow(()->new ResourceNotFoundException("Store","id",storeId));
        request.setStore(store);
        request.setUser(user);
        Request entity = requestRepo.save(request);
        return modelMapper.map(entity,RequestDTO.class);
    }

    @Override
    public RequestDTO updateRequest(RequestDTO requestDTO, int requestId) {
        Request request = requestRepo.findById(requestId)
                .orElseThrow(()-> new ResourceNotFoundException("Request","id",requestId));
        Request entity = requestRepo.save(request);
        return modelMapper.map(entity,RequestDTO.class);
    }

    @Override
    public RequestDTO getRequestById(int requestId) {
        Request request = requestRepo.findById(requestId)
                .orElseThrow(()->new ResourceNotFoundException("request","id",requestId));
        return modelMapper.map(request,RequestDTO.class);
    }

    @Override
    public List<RequestDTO> getAllRequest() {
        List<Request> requests = requestRepo.findAll();
        return requests.stream().map(request -> modelMapper.map(request,RequestDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteRequest(int requestId) {
        Request request = this.requestRepo.findById(requestId)
                .orElseThrow(()->new ResourceNotFoundException("Request","id",requestId));
        this.requestRepo.delete(request);
    }

    @Override
    public List<RequestDTO> getRequestByStore(int storeId) {
        List<Request> requests = this.requestRepo.findByStoreStoreId(storeId);
        List<RequestDTO> requestDTOs = requests.stream().map(request -> modelMapper.map(request,RequestDTO.class)).collect(Collectors.toList());
        return requestDTOs;
    }
}
