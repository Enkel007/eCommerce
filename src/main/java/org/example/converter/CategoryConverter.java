package org.example.converter;

import org.example.Entity.Category;
import org.example.dto.CategoryDTO;

public class CategoryConverter {
    public static Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setCategoryName(categoryDTO.getName());

        return category;
    }
}
