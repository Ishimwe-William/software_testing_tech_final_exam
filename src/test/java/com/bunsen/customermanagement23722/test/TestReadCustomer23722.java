package com.bunsen.customermanagement23722.test;

import com.bunsen.customermanagement23722.model.Warehouse;
import com.bunsen.customermanagement23722.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestReadCustomer23722 {

    private final CustomerService customerService;

    @Autowired
    public TestReadCustomer23722(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    @Tag("positive")
    @Sql("classpath:/insert_customer23722.sql")
    public void findCustomerByEmail_positive() {
        Optional<Warehouse> customer = customerService.findCustomerByEmail("customer2@gmail.com");

        Assertions.assertNotNull(customer.get());
        Assertions.assertEquals("customer2@gmail.com", customer.get().getEmail());
    }
    @Test
    @Tag("negative")
    @Sql("classpath:/insert_customer23722.sql")
    public void findCustomerByEmail_negative() {
        Optional<Warehouse> customer = customerService.findCustomerByEmail("customer20@gmail.com");
        Assertions.assertThrows(NoSuchElementException.class, ()-> customer.get());
    }

    @Test
    @Tag("positive")
    @Sql("classpath:/insert_customer23722.sql")
    public void findAllCustomer_positive() {
        List<Warehouse> customers = customerService.getAllCustomer();
        Assertions.assertNotNull(customers);
        Assertions.assertEquals(5,customers.size());
    }
}
