package com.hexagon.shop.application.port.in.cart;

import com.hexagon.shop.model.cart.Cart;
import com.hexagon.shop.model.cart.NotEnoughItemsInStockException;
import com.hexagon.shop.model.customer.CustomerId;
import com.hexagon.shop.model.product.ProductId;

public interface AddToCartUseCase {

    Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
            throws ProductNotFoundException, NotEnoughItemsInStockException;
}
