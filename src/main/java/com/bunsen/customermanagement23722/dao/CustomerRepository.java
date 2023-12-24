package com.bunsen.customermanagement23722.dao;

import com.bunsen.customermanagement23722.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Warehouse, String> {
    Optional<Warehouse> findCustomerByEmail(String email);
}

