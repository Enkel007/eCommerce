package org.example.dao;

import org.example.Entity.Category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDAOImplementation implements CategoryDAO {
    private final SessionFactory sessionFactory;

    public CategoryDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Category category) throws Exception {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        }catch(Exception e){
            throw new Exception(e.getLocalizedMessage());
        }
    }

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT a FROM Category a", Category.class).getResultList();
    }
}
