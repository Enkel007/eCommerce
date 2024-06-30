package org.example.dao;

import org.example.Entity.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAOImplementation implements ProductDAO {
    private final SessionFactory sessionFactory;

    public ProductDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) throws Exception {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch(Exception e){
            throw new Exception(e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Product findById(Long id) {
        return null;
    }


    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
    }
}
