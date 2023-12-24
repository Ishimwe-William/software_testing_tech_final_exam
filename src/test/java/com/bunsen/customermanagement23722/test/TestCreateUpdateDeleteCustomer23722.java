package com.bunsen.customermanagement23722.test;

import com.bunsen.customermanagement23722.model.Warehouse;
import com.bunsen.customermanagement23722.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestCreateUpdateDeleteCustomer23722 {

    private final CustomerService customerService;

    @Autowired
    public TestCreateUpdateDeleteCustomer23722(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    @Tag("positive")
    public void createCustomer_positive() {
        Warehouse warehouse = new Warehouse();
        LocalDate currentDate = LocalDate.now();

        warehouse.setCustomerID("Cust1");
        warehouse.setEmail("customer1@gmail.com");
        warehouse.setFirstName("Ishimwe");
        warehouse.setLastName("William");
        warehouse.setDateOfBirth(currentDate.minusYears(23));

        Warehouse saveWarehouse = customerService.saveCustomer(warehouse);
        Assertions.assertNotNull(saveWarehouse);
        Assertions.assertEquals("Cust1", saveWarehouse.getCustomerID());
    }

    @Test
    @Tag("negative")
    @Sql("classpath:/insert_customer23722.sql")
    public void createCustomer_negative() {
        Warehouse warehouse = new Warehouse();
        LocalDate currentDate = LocalDate.now();

        warehouse.setCustomerID("Cust2");
        warehouse.setEmail("customer2@gmail.com");
        warehouse.setFirstName("Ishimwe");
        warehouse.setLastName("William");
        warehouse.setDateOfBirth(currentDate.minusYears(23));
        Assert.assertNull(customerService.saveCustomer(warehouse));
    }


    @Test
    @Tag("positive")
    @Sql("classpath:/insert_customer23722.sql")
    public void updatedCustomer_positive() {
        Optional<Warehouse> foundCustomer = customerService.findCustomer("Cust2");
        if (foundCustomer.isPresent()) {
            Warehouse customer = foundCustomer.get();
            customer.setFirstName("Customer Updated");
            customer.setLastName("Customer Last Name updated");

            customerService.updateCustomer(customer);

            Optional<Warehouse> updatedCustomer = customerService.findCustomer("Cust2");

            Assertions.assertTrue(updatedCustomer.isPresent());
            Assertions.assertEquals("Customer Updated", updatedCustomer.get().getFirstName());

        }
    }

    @Test
    @Tag("negative")
    @Sql("classpath:/insert_customer23722.sql")
    public void updateCustomer_negative() {
        Optional<Warehouse> foundCustomer = customerService.findCustomer("Cust94");

        Assertions.assertFalse(foundCustomer.isPresent());

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Warehouse customer = foundCustomer.get();
            customer.setCustomerID("Cust12");
            customer.setFirstName("First Negative");
            customer.setPhoneNumber("08453455");
            customer.setDateOfBirth(LocalDate.now().minusYears(25));

            customerService.updateCustomer(customer);
        });
    }


    @Test
    @Tag("positive")
    @Sql("classpath:/insert_customer23722.sql")
    public void deleteCustomer_positive() {
        Optional<Warehouse> customer = customerService.findCustomer("Cust2");
        if (customer.isPresent()) {
            Warehouse deleteWarehouse = customer.get();
            customerService.deleteCustomer(deleteWarehouse.getCustomerID());

            // Wait for a short duration to allow asynchronous deletion to complete
            // Adjust the duration based on your specific use case and implementation
            try {
                Thread.sleep(1000); // 1 second as an example, you may need to adjust this
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Assertions.assertFalse(customerService.findCustomer("Cust2").isPresent());
    }


    @Test
    @Tag("negative")
    @Sql("classpath:/insert_customer23722.sql")
    public void deleteCustomer_negative() {
        // Attempt to delete a non-existent product with code "P100"
        Assertions.assertThrows(EntityNotFoundException.class, () -> customerService.deleteCustomer("Cust32"));
    }

}
