package com.rohit.apis.printApp.Controllers;

import com.rohit.apis.printApp.Payloads.DTOs.RequestDTO;
import com.rohit.apis.printApp.Payloads.Responses.ApiResponse;
import com.rohit.apis.printApp.Services.RequestService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/request")
public class RequestController {
    private final RequestService requestService;
    @PostMapping("/createRequest/{userId}/{storeId}")
    public ResponseEntity<RequestDTO> createRequest( @RequestBody RequestDTO requestDTO,@PathVariable int userId,@PathVariable int storeId){
        RequestDTO requestDTO1 = requestService.createRequest(requestDTO,userId,storeId);
        return new ResponseEntity<>(requestDTO1, HttpStatus.CREATED);
    }
    @PutMapping("updateRequest/{requestId}")
    public ResponseEntity<RequestDTO> updateRequest(@RequestBody RequestDTO requestDTO,@PathVariable int requestId){
        RequestDTO request= requestService.updateRequest(requestDTO,requestId);
        return new ResponseEntity<>(request,HttpStatus.OK);
    }
    @GetMapping("/getRequestById/{requestId}")
    public ResponseEntity<RequestDTO> getRequestById(@PathVariable int requestId){
        RequestDTO requestDTO = requestService.getRequestById(requestId);
        return new ResponseEntity<>(requestDTO,HttpStatus.OK);
    }
    @GetMapping("/getRequestsByStore/{storeId}")
    public ResponseEntity<List<RequestDTO>> getRequestsByStore(@PathVariable int storeId){
        List<RequestDTO> requestDTOS = this.requestService.getRequestByStore(storeId);
        return new ResponseEntity<>(requestDTOS,HttpStatus.OK);
    }
    @GetMapping("/getAllRequests")
    public ResponseEntity<List<RequestDTO>> getAllRequests(){
        List<RequestDTO> requestDTOS = requestService.getAllRequest();
        return new ResponseEntity<>(requestDTOS,HttpStatus.OK);
    }
    @DeleteMapping("/deleteRequest/{requestId}")
    public ResponseEntity<ApiResponse> deleteRequest(@PathVariable int requestId){
        requestService.deleteRequest(requestId);
        return new ResponseEntity<>(new ApiResponse("User Deleted",true),HttpStatus.OK);
    }
}
