package com.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "CustomerOrder")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Contact contact;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "holidayname")),
            @AttributeOverride(name = "address", column = @Column(name = "holidayaddress")),
            @AttributeOverride(name = "phone", column = @Column(name = "holidayphone")),
    })
    Contact holidayContact;

    private Long productId, customerId;

    private Integer price, quantity;
}
