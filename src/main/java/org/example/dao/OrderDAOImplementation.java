package org.example.dao;

import org.example.Entity.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrderDAOImplementation implements OrderDAO {
    private final SessionFactory sessionFactory;
    public OrderDAOImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Order create(Order order) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Order response = (Order) session.save(order);
            transaction.commit();
            return response;
        }
    }
}
