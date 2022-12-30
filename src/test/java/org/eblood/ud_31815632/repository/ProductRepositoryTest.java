package org.eblood.ud_31815632.repository;

import org.eblood.ud_31815632.entities.Category;
import org.eblood.ud_31815632.entities.Product;
import org.eblood.ud_31815632.entities.QRCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
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

        Category cat1 = new Category();
        cat1.setDescription("Category1");
        cat1.setCategoryName("Category#1");
        product.setCategory(cat1);

        QRCode code = new QRCode();
        code.setCode("111000110");
        product.setQrCode(code);

        productRepository.save(product);

        List<Product> allProducts = productRepository.findAll();

      //  allProducts.contains(product);
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


    @Test
    void findProductsByProductName() {
        List<Product> products =  productRepository.findProductsByProductName("P1");

        assertThat(products).hasAtLeastOneElementOfType(Product.class);
    }

    @Test
    void findProductsByPrice() {
        List<Product> products =  productRepository.findProductsByPrice__(1d);

        assertThat(products).hasAtLeastOneElementOfType(Product.class);
    }

    @Test
    void findProductsByCategory() {
        /*List<Product> products =  productRepository.findProductsByCategory(null);

        assertThat(products).hasAtLeastOneElementOfType(Product.class);*/
    }
}