package org.example.service;

import org.example.Entity.Product;
import org.example.config.HibernateConfig;
import org.example.converter.ProductConverter;
import org.example.dao.ProductDAO;
import org.example.dao.ProductDAOImplementation;
import org.example.dto.ProductDTO;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private final ProductDAO productDAO = new ProductDAOImplementation(sessionFactory);

    public void createProduct(ProductDTO productDTO) throws Exception {

        Product product = ProductConverter.convertToEntity(productDTO);
//        System.out.println(product); //test the conversion
        productDAO.save(product);
    }

    public Product findById(Long id) {
        return productDAO.findById(id);
    }

    public void deleteProduct(Long id) {
        productDAO.delete(id);
    }

    public List<Product> getAllProducts()  {
        return productDAO.findAll();
    }
}
