package com.example.Testy_Cwiczenie5.TDD_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ShoppingBasket {

	public static void main(String[] args)  {
		SpringApplication.run(ShoppingBasket.class, args);
	}

	private final List<Item> items;

	public ShoppingBasket(List<Item> itemList) {
		this.items = itemList;
	}

	public double getTotal() {
		return items.stream()
				.mapToDouble(Item::getSubtotal)
				.sum();
	}

}
