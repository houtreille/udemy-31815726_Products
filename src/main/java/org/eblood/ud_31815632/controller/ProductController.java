package org.eblood.ud_31815632.controller;

import org.eblood.ud_31815632.entities.Product;
import org.eblood.ud_31815632.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Long id){
        return service.getProductById(id);
    }


   /* @RequestMapping(method = RequestMethod.POST)
    public Product createProduct(Product product){
        return service.saveProduct(product);
    }*/

}
