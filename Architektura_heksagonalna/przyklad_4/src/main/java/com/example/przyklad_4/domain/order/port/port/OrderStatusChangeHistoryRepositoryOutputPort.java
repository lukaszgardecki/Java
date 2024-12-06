package com.example.przyklad_4.domain.order.port.port;

import com.example.przyklad_4.domain.order.port.OrderStatusChangeHistoryEntity;

import java.util.Collection;
import java.util.List;

public interface OrderStatusChangeHistoryRepositoryOutputPort {
    List<OrderStatusChangeHistoryEntity> getAllByOrderId(Long id);
}
