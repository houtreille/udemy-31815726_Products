package org.eblood.ud_31815632.controller;

import org.eblood.ud_31815632.entities.Product;
import org.eblood.ud_31815632.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;


    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Long id){
        return service.getProductById(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody Product product, @PathVariable("id") Long id){
        return service.getProductById(id).map(
                productToUpdate -> {
                    productToUpdate.setProductName(product.getProductName());
                    productToUpdate.setProductPrice(product.getProductPrice());
                    return service.saveProduct(productToUpdate);
                })
                .orElseGet( () -> {
                        return service.saveProduct(product);
                        }
                );
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        Optional<Product> productToDelete = service.getProductById(id);

        if(productToDelete.isPresent()) {
            service.deleteProduct(productToDelete.get());
        }
    }

    @GetMapping("/productByCategoryId/{categoryId}")
    public List<Product> getProductByCategoryId(@PathVariable("categoryId") Long categoryId ) {
        return service.getAllProductsByCategory(categoryId);
    }

}
