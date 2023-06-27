package com.bookshop.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private String streetAddress;
    private String city;
    private String country;
}
