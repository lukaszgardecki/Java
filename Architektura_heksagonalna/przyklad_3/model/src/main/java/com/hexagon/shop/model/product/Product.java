package com.hexagon.shop.model.product;

import com.hexagon.shop.model.money.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
public
class Product {

    private final ProductId id;
    private String name;
    private String description;
    private Money price;
    private int itemsInStock;
}
