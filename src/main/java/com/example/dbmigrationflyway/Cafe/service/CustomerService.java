package com.example.dbmigrationflyway.Cafe.service;

import com.example.dbmigrationflyway.Cafe.entity.Customers;
import com.example.dbmigrationflyway.Cafe.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customers> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customers> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public Customers addCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    public String deleteCustomer(Long id) {
        boolean exists = customerRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("customer with id: " + id + " doesn't exist");
        }
        customerRepository.deleteById(id);
        return "customer with id: "+ id + " deleted";
    }

    @Transactional
    public Customers updateCustomer(Long id, String firstName, String lastName, String phoneNumber, String address) {
        Customers customer = customerRepository.findById(id).orElseThrow(
                () ->new IllegalStateException("student with id: " + id + "doesn't exist"));
        if (firstName != null && firstName.length() > 0){
        customer.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0) {
            customer.setLastName(lastName);
        }
        if (phoneNumber != null && phoneNumber.length() > 0) {
            customer.setPhoneNumber(phoneNumber);
        }
        if (address != null && address.length() > 0) {
            customer.setAddress(address);
        }
        return customerRepository.save(customer);
    }
}
