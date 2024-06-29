package org.example.Entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //logs the time when the category was created
    @Column(name = "created_at")
    @CreationTimestamp
    public LocalDateTime createdAt;

    //logs the time when a value of the category is changed
    @Column(name = "updated_at")
    @CreationTimestamp
    public LocalDateTime updatedAt;

    private String categoryName;
}
