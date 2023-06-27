package com.bookshop.repository;

import com.bookshop.dto.CustomerDto;
import com.bookshop.model.Customer;
import com.bookshop.model.CustomerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c from Customer c LEFT JOIN FETCH c.orders")
    List<Customer> findCustomersAndOrders();

    @Query("SELECT new com.bookshop.dto.CustomerDto(c.id, c.name) from Customer c")
    List<CustomerDto> findCustomers();

    @Query("SELECT c FROM Customer c")
    List<CustomerProjection> findAllCustomers();

    CustomerProjection findOneByName(String name);
}
