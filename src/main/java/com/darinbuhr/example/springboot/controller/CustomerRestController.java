package com.darinbuhr.example.springboot.controller;

import com.darinbuhr.example.springboot.model.Customer;
import com.darinbuhr.example.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Simple rest controller example.
 */
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Customer getCustomer(@PathVariable("id") long id) {
        return customerService.find(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
    }
}
