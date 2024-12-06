package com.hexagon.shop.adapter.in.rest.product;

import com.hexagon.shop.model.money.Money;
import com.hexagon.shop.model.product.Product;

public record ProductInListWebModel(
        String id, String name, Money price, int itemsInStock) {

    public static ProductInListWebModel fromDomainModel(Product product) {
        return new ProductInListWebModel(
                product.id().value(), product.name(), product.price(), product.itemsInStock());
    }
}
