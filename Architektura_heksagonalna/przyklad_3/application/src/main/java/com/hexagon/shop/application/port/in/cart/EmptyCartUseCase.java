package com.hexagon.shop.application.port.in.cart;

import com.hexagon.shop.model.customer.CustomerId;

public interface EmptyCartUseCase {

    void emptyCart(CustomerId customerId);
}
