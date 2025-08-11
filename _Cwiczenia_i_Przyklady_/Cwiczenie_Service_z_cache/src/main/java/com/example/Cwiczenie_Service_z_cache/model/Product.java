package com.example.Cwiczenie_Service_z_cache.model;

import java.math.BigDecimal;

public record Product(String name, BigDecimal price, Category category) {

    public boolean isVegetable() {
        return category == Category.VEGETABLE;
    }

    public boolean hasPrice(BigDecimal expectedPrice) {
        return expectedPrice.compareTo(price) == 0;
    }

    public boolean hasCategory(Category expectedCategory) {
        return expectedCategory == category;
    }
}
