package com.bunsen.testsuite.dao;

import com.bunsen.testsuite.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select * from product where date_added > :date", nativeQuery = true)
    List<Product> findByDateAddedBefore(@Param("date") LocalDate date);

}

