package com.hexagon.shop.application.service.cart;

import com.hexagon.shop.application.port.in.cart.AddToCartUseCase;
import com.hexagon.shop.application.port.in.cart.ProductNotFoundException;
import com.hexagon.shop.application.port.out.persistance.CartRepository;
import com.hexagon.shop.application.port.out.persistance.ProductRepository;
import com.hexagon.shop.model.cart.Cart;
import com.hexagon.shop.model.cart.NotEnoughItemsInStockException;
import com.hexagon.shop.model.customer.CustomerId;
import com.hexagon.shop.model.product.Product;
import com.hexagon.shop.model.product.ProductId;

import java.util.Objects;

public class AddToCartService implements AddToCartUseCase {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public AddToCartService(
            CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
            throws ProductNotFoundException, NotEnoughItemsInStockException {
        Objects.requireNonNull(customerId, "'customerId' must not be null");
        Objects.requireNonNull(productId, "'productId' must not be null");
        if (quantity < 1) {
            throw new IllegalArgumentException("'quantity' must be greater than 0");
        }

        Product product =
                productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        Cart cart =
                cartRepository
                        .findByCustomerId(customerId)
                        .orElseGet(() -> new Cart(customerId));

        cart.addProduct(product, quantity);

        cartRepository.save(cart);

        return cart;
    }
}
