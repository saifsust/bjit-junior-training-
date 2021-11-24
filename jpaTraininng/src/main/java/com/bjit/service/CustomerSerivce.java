package com.bjit.service;

import com.bjit.model.Customer;
import com.bjit.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSerivce {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerSerivce(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> finalAll(){
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


    public Customer getOne(Long customerId) {
        return customerRepository.getById(customerId);
    }

    public void delete(Customer customer) {
         customerRepository.delete(customer);
    }
}
