package com.lab2.rest.service;

import com.lab2.exception.product.ProductNotFoundException;
import com.lab2.rest.dao.ProductDAO;
import com.lab2.rest.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product create(Product product) {
        return productDAO.save(product);
    }

    public Product update(Product productToUpdate) throws ProductNotFoundException {


        Product product = productDAO.findById(productToUpdate.getId());
        if (product == null)
            throw new ProductNotFoundException("Could not update. The product does not exist.");

        return productDAO.save(productToUpdate);
    }

    public void delete(long id) {
        productDAO.deleteById(id);
    }

    public Product findById(long id) {
        return productDAO.findById(id);
    }
}
