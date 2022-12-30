package org.eblood.ud_31815632.repository;

import org.eblood.ud_31815632.entities.Category;
import org.eblood.ud_31815632.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    @Transactional
    public void testSaveWithoutProduct(){

        Category cat1 = new Category();
        cat1.setDescription("Category1");
        cat1.setCategoryName("Category#1");
    }


    @Test
    public void testSaveWithProduct(){

        Category cat1 = new Category();
        cat1.setDescription("Category1");
        cat1.setCategoryName("Category#1");

        Product p1 = new Product();
        p1.setCreationDate(new Date());
        p1.setProductName("P1");
        p1.setProductPrice(1d);
        p1.setCategory(cat1);

        Product p2 = new Product();
        p2.setCreationDate(new Date());
        p2.setProductName("P2");
        p2.setProductPrice(2d);
        p2.setCategory(cat1);

        cat1.getProducts().add(p1);
        cat1.getProducts().add(p2);

        repository.save(cat1);

        List<Category> categories = repository.findAll();

        /*if(categories.size() >= 1) {
            List products = categories.get(0).getProducts();
            //Needs @Transactional for this
            products.forEach(o -> System.out.println(o));
        }*/

    }



    @Test
    public void testDeleteProduct(){
        List<Category> cats = repository.findAll();

        repository.delete(cats.get(0));
    }


}