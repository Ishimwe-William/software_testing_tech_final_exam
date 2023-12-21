package com.bunsen.testsuite.dao;

import com.bunsen.testsuite.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByDateAddedGreaterThan(LocalDate date);
}

