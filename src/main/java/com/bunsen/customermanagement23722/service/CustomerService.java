package com.bunsen.customermanagement23722.service;

import com.bunsen.customermanagement23722.dao.CustomerRepository;
import com.bunsen.customermanagement23722.model.Warehouse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Warehouse saveCustomer(Warehouse warehouse){
        if(!findCustomer(warehouse.getCustomerID()).isPresent()) {
            return customerRepository.save(warehouse);
        }
        else {
            return null;
        }
    }

    public List<Warehouse> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void updateCustomer(Warehouse warehouse) {
        if (findCustomer(warehouse.getCustomerID()).isPresent()) {
            customerRepository.save(warehouse);
        }
    }

    public Optional<Warehouse> findCustomer(String customerID) {
        return customerRepository.findById(customerID);
    }

    public Optional<Warehouse> findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    public void deleteCustomer(String customerId) {
        findCustomer(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found with code: " + customerId));
        customerRepository.deleteById(customerId);
    }
}
