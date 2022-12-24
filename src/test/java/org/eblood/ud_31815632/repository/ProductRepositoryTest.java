package org.eblood.ud_31815632.repository;

import org.eblood.ud_31815632.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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


    @Test
    public void testFindAll(){

        long count = productRepository.count();

        List<Product> products =  productRepository.findAll();

        assertThat(products.size()).isEqualTo(count);
    }

    @Test
    public void testDeleteById(){

        List<Product> products =  productRepository.findAll();

        Long productId = products.get(0).getProductId();
        productRepository.deleteById(productId);

        assertThat(productRepository.existsById(productId)).isFalse();
    }


    @Test
    public void testUpdateById(){

        List<Product> products =  productRepository.findAll();
        Product productToUpdate = products.get(0);

        productToUpdate.setProductPrice(1234d);
        productRepository.save(productToUpdate);

        assertThat(productRepository.findAll().contains(productToUpdate)).isEqualTo(Boolean.TRUE);

    }


}