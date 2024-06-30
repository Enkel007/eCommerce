package org.example.dao;

import org.example.Entity.Product;

import java.util.List;

public interface ProductDAO {
    void save(Product product) throws Exception;
//    void update(Product product);
    void delete(Long id);
    Product findById(Long id);
    List<Product> findAll();
}
