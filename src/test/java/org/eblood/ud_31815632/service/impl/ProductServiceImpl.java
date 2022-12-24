package org.eblood.ud_31815632.service.impl;

import org.eblood.ud_31815632.entities.Product;
import org.eblood.ud_31815632.repository.ProductRepository;
import org.eblood.ud_31815632.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        repository.delete(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
}
