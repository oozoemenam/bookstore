package com.bookshop.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "Customer")
@DynamicInsert
@DynamicUpdate
public class Costomer {
    @Id
    @GenericGenerator(name = "customergen", strategy = "increment")
    private Long id;

    @ElementCollection(targetClass = Address.class, fetch = FetchType.EAGER)
    @JoinTable(name = "Address", joinColumns = @JoinColumn(name = "customer_id"))
    private Set<Address> contacts;
}
