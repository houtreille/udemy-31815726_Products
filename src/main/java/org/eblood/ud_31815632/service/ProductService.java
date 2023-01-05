package org.eblood.ud_31815632.service;

import org.eblood.ud_31815632.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

     List<Product> getAllProducts();
     Product saveProduct(Product product);
     void deleteProduct(Product product);
     Product updateProduct(Product product);
     Optional<Product> getProductById(Long id);
     List<Product> getAllProductsByCategory(Long id);

}
