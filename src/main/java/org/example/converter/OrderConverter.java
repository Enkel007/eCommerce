package org.example.converter;

import org.example.Entity.Client;
import org.example.Entity.Order;
import org.example.Entity.OrderItems;
import org.example.Entity.Product;
import org.example.dto.OrderDTO;
import org.example.dto.OrderItemsDTO;
import org.example.enums.PaymentStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public static Order convertOrderToEntity(OrderDTO orderRequest) {
        Order order = new Order();
        order.setPaymentStatus(PaymentStatusEnum.valueOf(orderRequest.getPaymentStatus()));
        order.setClient(new Client(orderRequest.getClientId()));
        order.setOrderItemsList(convertItemToEntity(orderRequest.getOrderItemsDTOList()));
        return order;
    }

    public static List<OrderItems> convertItemToEntity(List<OrderItemsDTO> request) {
        List<OrderItems> orderItemsList = new ArrayList<>();
        for (OrderItemsDTO orderItemsRequest: request) {
            OrderItems orderItem = new OrderItems();
            orderItem.setProduct(new Product(orderItemsRequest.getProductId()));
            orderItem.setQuantity(orderItemsRequest.getQuantity());
            orderItemsList.add(orderItem);
        }
        return orderItemsList;
    }
}
