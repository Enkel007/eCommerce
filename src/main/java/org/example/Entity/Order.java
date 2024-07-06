package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.OrderStatusEnum;
import org.example.enums.PaymentStatusEnum;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "order_table")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "order_table")
    private List<OrderItems> orderItemsList;

    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatusEnum paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    @ColumnDefault("NEW")
    private OrderStatusEnum orderStatus;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
