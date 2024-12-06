package com.example.przyklad_4.appliaction;

import com.example.przyklad_4.appliaction.dto.OrderStatusChangeDTO;
import com.example.przyklad_4.domain.order.port.OrderEntity;
import com.example.przyklad_4.domain.order.port.OrderStatusChangeHistoryEntity;
import com.example.przyklad_4.domain.order.port.port.OrderRepositoryOutputPort;
import com.example.przyklad_4.domain.order.port.port.OrderStatusChangeHistoryRepositoryInputPort;
import com.example.przyklad_4.domain.order.port.port.OrderStatusChangeHistoryRepositoryOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import static java.util.Comparator.comparing;
import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
class ChangeOrderStatusUseCase {
    private final OrderRepositoryOutputPort orderRepositoryOutputPort;
    private final OrderStatusChangeHistoryRepositoryOutputPort orderStatusChangeHistoryRepositoryOutputPort;
    private final OrderStatusChangeHistoryRepositoryInputPort orderStatusChangeHistoryRepositoryInputPort;

    @Transactional
    public void execute(OrderStatusChangeDTO dto) {
        OrderEntity order = orderRepositoryOutputPort.getByUUID(dto.getOrderUUID());
        OrderStatusChangeHistoryEntity latestStatusChange =
                orderStatusChangeHistoryRepositoryOutputPort
                        .getAllByOrderId(order.getId())
                        .stream()
                        .max(comparing(OrderStatusChangeHistoryEntity::getChangeDate))
                        .orElse(null);
        validateOrderStatusChange(dto, latestStatusChange);
        OrderStatusChangeHistoryEntity statusChange =
                new OrderStatusChangeHistoryEntity(
                        order.getId(),
                        requireNonNull(latestStatusChange).getCurrentStatus(),
                        dto.getOrderStatus()
                );
        orderStatusChangeHistoryRepositoryInputPort.save(statusChange);
    }

    private void validateOrderStatusChange(OrderStatusChangeDTO dto, OrderStatusChangeHistoryEntity latestStatusChange) {

    }
}
