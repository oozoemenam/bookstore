package com.bookshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ISBN implements Serializable {
    @Column(name = "group_number")
    int group;

    int publisher;
    int titleRef;
    int checkDigit;
}
