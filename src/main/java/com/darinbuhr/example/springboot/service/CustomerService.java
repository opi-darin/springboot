package com.darinbuhr.example.springboot.service;

import com.darinbuhr.example.springboot.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer find(long id);

    Customer create(Customer customer);

    Customer update(Customer customer);

    boolean delete(long id);
}
