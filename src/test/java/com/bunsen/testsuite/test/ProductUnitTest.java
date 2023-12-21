package com.bunsen.testsuite.test;

import com.bunsen.testsuite.model.Product;
import com.bunsen.testsuite.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductUnitTest {

    private final ProductService productService;

    @Autowired
    public ProductUnitTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    @Tag("positive")
    public void testPositiveSave(){
        Product product = new Product();
        product.setProductCode("P1");
        product.setProductName("Prod1");
        product.setCategory("Cat1");
        product.setQuantity(10);
        product.setPrice(BigDecimal.valueOf(102.13));
        product.setDateAdded(LocalDate.now());

        Product saveProduct = productService.saveProduct(product);
        assertNotNull(saveProduct);
        Assertions.assertEquals("P1", saveProduct.getProductCode());
    }

    @Test
    @Tag("negative")
    public void testNegativeSave(){
        Product product = new Product();
        product.setProductCode("P1");
        product.setProductName("Prod1");
        product.setCategory("Cat1");
        product.setQuantity(-10);
        product.setPrice(BigDecimal.valueOf(-102.13));
        product.setDateAdded(LocalDate.now());

        Assert.assertThrows(InvalidDataAccessApiUsageException.class,() -> productService.saveProduct(product));
    }

    @Test
    @Tag("positive")
    @Sql("classpath:/insertData.sql")
    public void testPositiveRead(){
        Optional<Product> product = productService.findProduct("P2");

        assertNotNull(product.get());
        Assertions.assertEquals("P2", product.get().getProductCode());
    }

    @Test
    @Tag("negative")
    @Sql("classpath:/insertData.sql")
    public void testNegativeRead(){
        Assert.assertThrows(EntityNotFoundException.class, () -> productService.findProduct("P10"));
    }

    @Test
    @Tag("positive")
    @Sql("classpath:/insertData.sql")
    public void testPositiveGetAll(){
        List<Product> products = productService.getAllProducts();

        assertNotNull(products);
        assertTrue(products.size()>=4);
    }

    @Test
    @Tag("positive")
    @Sql("classpath:/insertData.sql")
    public void testPositiveGetProductsByDate() {
        LocalDate currentDate = LocalDate.now();
        List<Product> productsByDate = productService.getProductsByDate(currentDate.minusDays(1));

        assertNotNull(productsByDate);
        assertTrue(productsByDate.size() <= 3);
    }

}
