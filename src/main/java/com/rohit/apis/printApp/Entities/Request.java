package com.rohit.apis.printApp.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int requestId;
    String color;
    String size;
    @ManyToOne
    User user;
    @ManyToOne
    Store store;
    String pdfLink;
}
