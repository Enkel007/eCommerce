package org.example.client;

import org.example.Entity.OrderItems;
import org.example.dto.OrderDTO;
import org.example.dto.OrderItemsDTO;
import org.example.enums.PaymentStatusEnum;
import org.example.service.OrderService;
import org.example.service.OrderServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Give the ");

        System.out.println("Ju lutem fusni client id tuaj");
        Long clientId = sc.nextLong();
        System.out.println("Ju lutem fusni payemt status");
        String payementStatus = sc.next();
        List<OrderItemsDTO> orderItemsRequestList = new ArrayList<>();
        int c;
        do {
            System.out.println("Ju lutem fusni product ID, fusni product id = 300 kur ");
            Long productId = sc.nextLong();
            System.out.println("Ju lutem fusni sasine per kte product");
            Integer quantity = sc.nextInt();
            OrderItemsDTO orderItemsRequest = new OrderItemsDTO(productId, quantity);
            orderItemsRequestList.add(orderItemsRequest);
            System.out.println("Ju lutem shtypni 1 per te vazhduar te shtoni produkte" +
                    " dhe 0 nese lista e produkteve eshte plotesuar ");
            c = sc.nextInt();
        } while (c != 0);

        OrderDTO orderRequest = new OrderDTO();
        orderRequest.setClientId(clientId);
        orderRequest.setOrderItemsDTOList(orderItemsRequestList);
        orderRequest.setPaymentStatus(String.valueOf(PaymentStatusEnum.valueOf(payementStatus)));
        OrderService orderService = new OrderServiceImplementation();
        orderService.create(orderRequest);
    }
}
