package com.example.dbmigrationflyway.Cafe.controller;


import com.example.dbmigrationflyway.Cafe.entity.Customers;
import com.example.dbmigrationflyway.Cafe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customers> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping("/{id}")
    public Optional<Customers> getDessert(@PathVariable("id") Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping("/add")
    public Customers newCustomer(@RequestBody Customers customer){
       return customerService.addCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping("/update/{id}")
    public Customers updateCustomer(@PathVariable Long id,
                                    @RequestParam(required = false) String firstName,
                                    @RequestParam(required = false) String lastName,
                                    @RequestParam(required = false) String phoneNumber,
                                    @RequestParam(required = false) String address){
        return customerService.updateCustomer(id, firstName, lastName, phoneNumber, address);
    }
}

