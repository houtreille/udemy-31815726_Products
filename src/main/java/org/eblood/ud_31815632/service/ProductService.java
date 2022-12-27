package org.eblood.ud_31815632.service;

import org.eblood.ud_31815632.entities.Product;

import java.util.List;

public interface ProductService {

     List<Product> getAllProducts();
     Product saveProduct(Product product);
     void deleteProduct(Product product);
     Product updateProduct(Product product);

}
