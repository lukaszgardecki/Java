package com.hexagon.shop.application.service.cart;

import com.hexagon.shop.application.port.in.cart.EmptyCartUseCase;
import com.hexagon.shop.application.port.out.persistance.CartRepository;
import com.hexagon.shop.model.customer.CustomerId;

import java.util.Objects;

public class EmptyCartService implements EmptyCartUseCase {

    private final CartRepository cartRepository;

    public EmptyCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void emptyCart(CustomerId customerId) {
        Objects.requireNonNull(customerId, "'customerId' must not be null");

        cartRepository.deleteByCustomerId(customerId);
    }
}
