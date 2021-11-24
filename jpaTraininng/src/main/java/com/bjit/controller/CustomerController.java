package com.bjit.controller;

import com.bjit.model.Customer;
import com.bjit.service.CustomerSerivce;
import org.hibernate.bytecode.enhance.spi.interceptor.AbstractLazyLoadInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerSerivce customerSerivce;

     private final String ALL_CUSTOMER_ROUTE ="/customer";

    @Autowired
    public CustomerController(CustomerSerivce customerSerivce) {
        this.customerSerivce = customerSerivce;
    }

    @GetMapping(path = {ALL_CUSTOMER_ROUTE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Customer> findAll(){
        return customerSerivce.finalAll();
    }

    @PostMapping(path = {ALL_CUSTOMER_ROUTE}, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Customer save(@RequestBody Customer customer){
        return customerSerivce.save(customer);
    }

    @PatchMapping(path = {ALL_CUSTOMER_ROUTE+"/{customerId}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Customer getfOne(@PathVariable("customerId") Long customerId){
        return customerSerivce.getOne(customerId);
    }

    @DeleteMapping(path = {ALL_CUSTOMER_ROUTE}, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody Customer customer){
         customerSerivce.delete(customer);
    }

}
