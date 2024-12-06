package com.example.przyklad_4.domain.order.port.port;

import com.example.przyklad_4.domain.order.port.OrderStatusChangeHistoryEntity;

public interface OrderStatusChangeHistoryRepositoryInputPort {
    void save(OrderStatusChangeHistoryEntity statusChange);
}
