package com.bookshop.model;

import org.springframework.beans.factory.annotation.Value;

public interface CustomerProjection {
    String getName();
    String getEmail();

    @Value("#{target.name + '_' + target.email}")
    String getCustomerNameAndEmail();
}
