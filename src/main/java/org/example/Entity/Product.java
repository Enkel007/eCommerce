package org.example.Entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //logs the time when the product was created
    @Column(name = "created_at")
    @CreationTimestamp
    public LocalDateTime createdAt;

    //logs the time when a value of the product is changed
    @Column(name = "updated_at")
    @CreationTimestamp
    public LocalDateTime updatedAt;

    //main info about the product
    private String name;
    private String description;
    private Double price;
    private Integer quantity;

    //we connect the tables(entities) product and category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
