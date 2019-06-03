package com.lab2.rest.controller;

import com.lab2.exception.product.ProductNotFoundException;
import com.lab2.rest.model.Product;
import com.lab2.rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/v1/product"})
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product newProduct = productService.create(product);

        if (newProduct == null) {
            throw new InternalError("Something went wrong");
        }

        return new ResponseEntity<Product>((Product) newProduct, HttpStatus.CREATED);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        Product product = productService.findById(id);
        
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }
        
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }


    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        try {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new InternalError("Something went wrong");
        }
    }

    @PutMapping(value="/")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        try {
            Product updated = productService.update(product);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            throw new InternalError("Something went wrong");
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {

        try {
            List<Product> result = productService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



}
