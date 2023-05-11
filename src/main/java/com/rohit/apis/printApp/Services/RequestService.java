package com.rohit.apis.printApp.Services;

import com.rohit.apis.printApp.Payloads.DTOs.RequestDTO;

import java.util.List;

public interface RequestService {
    RequestDTO createRequest(RequestDTO requestDTO,int userId,int storeId);
    RequestDTO updateRequest(RequestDTO requestDTO,int requestId);
    RequestDTO getRequestById(int requestId);
    List<RequestDTO> getAllRequest();
    void deleteRequest(int requestId);
    List<RequestDTO> getRequestByStore(int storeId);
}
