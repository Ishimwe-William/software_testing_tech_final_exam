package com.bunsen.testsuite.service;

import com.bunsen.testsuite.dao.ProductRepository;
import com.bunsen.testsuite.model.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByDate(LocalDate date) {
        return productRepository.findByDateAddedBefore(date);
    }

    public void updateProduct(Product product) {
        if(findProduct(product.getProductCode()).isPresent()){
            productRepository.save(product);
        }
    }

    public void deleteProduct(String productCode) {
        if(findProduct(productCode).isPresent()){
            productRepository.deleteById(productCode);
        }
    }

    public Optional<Product> findProduct(String productCode){
        if(productRepository.findById(productCode).isPresent()){
           return productRepository.findById(productCode);
        }else{
            throw new EntityNotFoundException("No product with that code");
        }
    }
}
