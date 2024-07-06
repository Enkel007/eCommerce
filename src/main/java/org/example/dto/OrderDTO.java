package org.example.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    private Long clientId;
    private String paymentStatus;

    List<OrderItemsDTO> orderItemsDTOList = new ArrayList<>();
}
