package org.eblood.ud_31815632.repository;

import org.eblood.ud_31815632.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {


    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSave(){

        Product product = new Product();
        product.setProductName("A product");
        product.setProductPrice(10d);
        product.setCreationDate(new Date());

        productRepository.save(product);

        List<Product> allProducts = productRepository.findAll();

        allProducts.contains(product);


    }

}