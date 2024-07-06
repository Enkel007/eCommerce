package org.example.dao;

import org.example.Entity.Category;

import java.util.List;

public interface CategoryDAO {
    void save(Category category) throws Exception;

    List<Category> findAll();
}
