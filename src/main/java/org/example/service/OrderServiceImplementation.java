package org.example.service;

import org.example.Entity.Product;
import org.example.config.HibernateConfig;
import org.example.converter.OrderConverter;
import org.example.dao.OrderDAO;
import org.example.dao.OrderDAOImplementation;
import org.example.dao.ProductDAOImplementation;
import org.example.dto.OrderDTO;
import org.hibernate.SessionFactory;

import org.example.dao.ProductDAO;
import org.example.Entity.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImplementation implements OrderService {
    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private ProductDAO productDao = new ProductDAOImplementation(sessionFactory);
    private OrderDAO orderDao = new OrderDAOImplementation(sessionFactory);
    @Override
    public Order create(OrderDTO orderRequest) {
        List<Long> productIds = orderRequest.getOrderItemsDTOList()
                .stream()
                .map(orderItemRequest -> orderItemRequest.getProductId())
                .collect(Collectors.toList());

        Map<Long, Double> mapPrice = new HashMap<>();

        List<Product> getProducts = productDao.findAllByIds(productIds);

        for (Product product: getProducts) {
            mapPrice.put(product.getId(), product.getPrice());
        }

        Order order = OrderConverter.convertOrderToEntity(orderRequest);
        order.getOrderItemsList().stream().forEach(
                orderItems -> orderItems.setSubTotal(orderItems.getQuantity()
                        * mapPrice.get(orderItems.getProduct().getId()))
        );

        Double total = order.getOrderItemsList().stream().mapToDouble(
                orderItem -> orderItem.getSubTotal()
        ).sum();

        order.setTotal(total);
        return orderDao.create(order);
    }
}
