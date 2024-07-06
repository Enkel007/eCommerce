package org.example.service;

import org.example.dto.OrderDTO;
import org.example.Entity.Order;

public interface OrderService {
    Order create(OrderDTO orderRequest);
}
