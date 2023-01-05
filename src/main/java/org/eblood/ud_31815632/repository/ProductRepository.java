package org.eblood.ud_31815632.repository;


import org.eblood.ud_31815632.entities.Category;
import org.eblood.ud_31815632.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findProductsByProductName(String productName);

    @Query("select p from Product p where p.productPrice >= :price")
    List<Product> findProductsByPrice__(@Param("price") Double price);

    List<Product> findProductsByCategoryIdCategory(Long categoryId);

    /*
    @Query("select p from Product p where p.category = :category ")
    List<Product> findProductsByCategory__(@Param("category") Category category);*/
}
