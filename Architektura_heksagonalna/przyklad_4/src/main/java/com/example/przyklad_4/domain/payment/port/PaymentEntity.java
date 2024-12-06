package com.example.przyklad_4.domain.payment.port;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name="t_payment")
public class PaymentEntity {
    @Id
    private UUID uuid;
    private Long userId;
    private PaymentType paymentType;
    private BigDecimal freeAmount;
    private BigDecimal realAmount;
    private OffsetDateTime createDate;


    public PaymentEntity() {
        this.uuid = UUID.randomUUID();
        this.createDate = OffsetDateTime.now();
    }

    public PaymentEntity(Long userId,
                         PaymentType paymentType,
                         BigDecimal freeAmount,
                         BigDecimal realAmount) {
        this.uuid = UUID.randomUUID();
        this.createDate = OffsetDateTime.now();
        this.userId = userId;
        this.paymentType = paymentType;
        this.freeAmount = freeAmount;
        this.realAmount = realAmount;
    }
}
