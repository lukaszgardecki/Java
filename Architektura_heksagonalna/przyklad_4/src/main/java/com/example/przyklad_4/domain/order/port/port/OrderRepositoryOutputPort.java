package com.example.przyklad_4.domain.order.port.port;

import com.example.przyklad_4.domain.order.port.OrderEntity;

public interface OrderRepositoryOutputPort {

    OrderEntity getByUUID(String uuid);
}
