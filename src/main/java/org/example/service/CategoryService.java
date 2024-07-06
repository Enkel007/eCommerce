package org.example.service;

import org.example.Entity.Category;
import org.example.Entity.Product;
import org.example.config.HibernateConfig;
import org.example.converter.CategoryConverter;

import org.example.dao.CategoryDAO;
import org.example.dao.CategoryDAOImplementation;

import org.example.dto.CategoryDTO;

import org.hibernate.SessionFactory;

import java.util.List;

public class CategoryService {
    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private final CategoryDAO categoryDAO = new CategoryDAOImplementation(sessionFactory);

    public void createCategory(CategoryDTO categoryDTO) throws Exception {

        Category category = CategoryConverter.convertToEntity(categoryDTO);
//        System.out.println(category); //test the conversion
        categoryDAO.save(category);
    }

    public List<Category> getAllCategories()  {
        return categoryDAO.findAll();
    }
}
