package com.example.przyklad_4.domain.order.port;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "t_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid", nullable = false, unique = true)
    private UUID uuid;
    @Column(name = "order_date")
    private OffsetDateTime orderDate;
    @Column(name = "cart_id", nullable = false)
    private Long cartId;
    @Column(name = "shipping_id", nullable = false)
    private Long shippingId;
}
