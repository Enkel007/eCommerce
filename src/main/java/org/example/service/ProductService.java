package org.example.service;

import org.example.Entity.Product;
import org.example.converter.ProductConverter;
import org.example.dto.ProductDTO;

public class ProductService {
    public void createProduct(ProductDTO productDTO){

        Product product = ProductConverter.convertToEntity(productDTO);
        System.out.println(product);

    }
}
