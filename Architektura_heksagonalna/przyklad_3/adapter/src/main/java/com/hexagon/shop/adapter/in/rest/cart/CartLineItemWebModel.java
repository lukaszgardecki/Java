package com.hexagon.shop.adapter.in.rest.cart;


import com.hexagon.shop.model.cart.CartLineItem;
import com.hexagon.shop.model.money.Money;
import com.hexagon.shop.model.product.Product;

public record CartLineItemWebModel(
        String productId, String productName, Money price, int quantity) {

    public static CartLineItemWebModel fromDomainModel(CartLineItem lineItem) {
        Product product = lineItem.product();
        return new CartLineItemWebModel(
                product.id().value(), product.name(), product.price(), lineItem.quantity());
    }
}
