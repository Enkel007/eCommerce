package org.example.service;

import org.example.Entity.Product;
import org.example.config.HibernateConfig;
import org.example.converter.ProductConverter;
import org.example.dao.ProductDAO;
import org.example.dao.ProductDAOImplementation;
import org.example.dto.ProductDTO;
import org.hibernate.SessionFactory;

public class ProductService {
    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private final ProductDAO productDAO = new ProductDAOImplementation(sessionFactory);

    public void createProduct(ProductDTO productDTO) throws Exception {

        Product product = ProductConverter.convertToEntity(productDTO);
//        System.out.println(product); //test the conversion
        productDAO.save(product);
    }
}
