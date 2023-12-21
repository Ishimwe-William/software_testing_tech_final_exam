package com.bunsen.testsuite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Product {

    @Id
    @Column(unique = true)
    private String productCode;
    private String productName;
    private String category;
    private Integer quantity;
    private BigDecimal price;
    private LocalDate dateAdded;

    @PrePersist
    void validateQuantityAndPrice() {

        // on create
        this.dateAdded = LocalDate.now();

        // a constraint to the database to ensure that the quantity and
        // price attributes do not accept values less than 0
        if (quantity != null && quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }

        if (price != null && price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
    }
}