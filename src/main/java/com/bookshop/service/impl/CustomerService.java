package com.bookshop.service.impl;

import com.bookshop.model.Customer;
import com.bookshop.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void registerNewCustomers() {
        Customer customer = new Customer();
        customer.setName("Customer 1");
        customer.setEmail("c1@example.com");
        customer.setPassword("password");
        customer.setDateJoined(LocalDateTime.now());
        customerRepository.saveAndFlush(customer);
        log.info("Registered customers: " + customerRepository.findAll());
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
