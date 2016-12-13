package com.darinbuhr.example.springboot.service;

import com.darinbuhr.example.springboot.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Customer service using example test data.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private static final List<Customer> CUSTOMERS = new ArrayList<>(
            Arrays.asList(
                    new Customer(1, "John", "Doe"),
                    new Customer(2, "Jane", "Doe"),
                    new Customer(3, "John", "Smith")
            ));
    private long nextCustomerId = 4;

    @Override
    public List<Customer> findAll() {
        return CUSTOMERS;
    }

    @Override
    public Customer find(long id) {
        Optional<Customer> result = CUSTOMERS
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public Customer create(Customer customer) {
        customer.setId(generateCustomerId());
        CUSTOMERS.add(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> result = CUSTOMERS
                .stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst();

        if (result.isPresent()) {
            Customer existing = result.get();
            existing.setFirstName(customer.getFirstName());
            existing.setLastName(customer.getLastName());
            return existing;
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return CUSTOMERS.removeIf(c -> c.getId() == id);
    }

    private long generateCustomerId() {
        return nextCustomerId++;
    }
}
