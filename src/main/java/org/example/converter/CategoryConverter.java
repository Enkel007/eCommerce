package org.example.converter;

import org.example.Entity.Category;
import org.example.Entity.Product;
import org.example.dto.CategoryDTO;
import org.example.dto.ProductDTO;

public class CategoryConverter {
    public static Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setCategoryName(categoryDTO.getName());

        return category;
    }
}
