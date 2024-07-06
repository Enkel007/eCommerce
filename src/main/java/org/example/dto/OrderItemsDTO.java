package org.example.dto;

import lombok.Data;

@Data
public class OrderItemsDTO {
    private Long productId;
    private Integer quantity;
}
