package org.example.converter;

import org.example.Entity.Category;
import org.example.Entity.Product;
import org.example.dto.ProductDTO;

public class ProductConverter {

    //turn a productDto to a product entity(table)
    public static Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(new Category(productDTO.getCategoryId()));

        return product;
    }
}
