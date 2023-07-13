package com.bookshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(EmployeeId.class)
public class Employee {
    @Id
    private Long department;

    @Id
    private Long idCard;

    @Column(unique = true, nullable = false)
    private String name;
}
