package org.example.dao;

import org.example.Entity.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = findById(id);
        session.delete(product);
        transaction.commit();
    }

    @Override
    public Product findById(Long id) {
        Session session = sessionFactory.openSession();
        Product product = (Product) session.get(Product.class, id);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
    }

    @Override
    public List<Product> findAllByIds(List<Long> ids) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Product where id in (:ids)",
                Product.class);
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
