package com.hexagon.shop.model.cart;

import com.hexagon.shop.model.customer.CustomerId;

import java.util.concurrent.ThreadLocalRandom;

public class TestCartFactory {

    public static Cart emptyCartForRandomCustomer() {
        return new Cart(new CustomerId(ThreadLocalRandom.current().nextInt(1_000_000)));
    }
}
