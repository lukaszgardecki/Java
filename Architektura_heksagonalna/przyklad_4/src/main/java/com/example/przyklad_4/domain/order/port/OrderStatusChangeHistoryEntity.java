package com.example.przyklad_4.domain.order.port;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusChangeHistoryEntity {
    @Id
    private Long id;
    private String currentStatus;
    private String orderStatus;


    public LocalDate getChangeDate() {

        return null;
    }
}
