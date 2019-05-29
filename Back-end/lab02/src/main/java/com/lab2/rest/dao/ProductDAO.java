package com.lab2.rest.dao;

import com.lab2.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProductDAO<T, ID extends Serializable> extends JpaRepository<Product, Long> {

    Product save(Product product);

    Product findById(long id);
}
