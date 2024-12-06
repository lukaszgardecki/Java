package com.hexagon.shop.application.service.cart;

import com.hexagon.shop.application.port.in.cart.GetCartUseCase;
import com.hexagon.shop.application.port.out.persistance.CartRepository;
import com.hexagon.shop.model.cart.Cart;
import com.hexagon.shop.model.customer.CustomerId;

import java.util.Objects;

public class GetCartService implements GetCartUseCase {

    private final CartRepository cartRepository;

    public GetCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCart(CustomerId customerId) {
        Objects.requireNonNull(customerId, "'customerId' must not be null");

        return cartRepository
                .findByCustomerId(customerId)
                .orElseGet(() -> new Cart(customerId));
    }
}
