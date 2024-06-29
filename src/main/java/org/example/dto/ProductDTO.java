package org.example.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private Long categoryId;
}
