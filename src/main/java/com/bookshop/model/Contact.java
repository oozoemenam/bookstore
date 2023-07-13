package com.bookshop.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.annotations.Parent;

@Embeddable
@Data
public class Contact {
    String name;
//    String address;
    String phone;
    Address address;
}
