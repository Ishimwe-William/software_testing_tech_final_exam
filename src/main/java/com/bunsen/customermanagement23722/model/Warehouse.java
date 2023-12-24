package com.bunsen.customermanagement23722.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Warehouse {
    @Id
    @Column(unique = true)
    private String CustomerID;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
}