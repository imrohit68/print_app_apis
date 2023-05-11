package com.rohit.apis.printApp.Payloads.DTOs;

import com.rohit.apis.printApp.Entities.User;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestDTO {
    int requestId;
    String color;
    String size;
    UserDTOResponse user;
    String pdfLink;
}
