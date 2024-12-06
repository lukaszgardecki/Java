package com.hexagon.shop.application.port.in.cart;

import com.hexagon.shop.model.cart.Cart;
import com.hexagon.shop.model.customer.CustomerId;

public interface GetCartUseCase {

    Cart getCart(CustomerId customerId);
}
