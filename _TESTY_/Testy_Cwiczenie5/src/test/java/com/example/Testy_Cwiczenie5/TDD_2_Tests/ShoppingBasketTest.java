package com.example.Testy_Cwiczenie5.TDD_2_Tests;

import com.example.Testy_Cwiczenie5.TDD_2.Item;
import com.example.Testy_Cwiczenie5.TDD_2.ShoppingBasket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShoppingBasketTest {

	@Test
	@DisplayName("Total of empty basket")
	public void totalOfBasket() {
		ShoppingBasket basket = buildBasketWithItems();
		assertEquals(0.0, basket.getTotal());
	}

	@Test
	@DisplayName("Total of single product")
	public void totalOfSingleItem() {
		ShoppingBasket basket = buildBasketWithItems(
				new Item(100.0, 1)
		);
		assertEquals(100.0, basket.getTotal());
	}

	@Test
	@DisplayName("Total of two products")
	public void totalOfTwoItems() {
		ShoppingBasket basket = buildBasketWithItems(
				new Item(100.0, 1),
				new Item(200.0, 1)
		);
		assertEquals(300.0, basket.getTotal());
	}

	@Test
	@DisplayName("Total of one double product")
	public void totalOfItemWithQuantityTwo() {
		ShoppingBasket basket = buildBasketWithItems(
				new Item(100.0, 2)
		);
		assertEquals(200.0, basket.getTotal());
	}






	private ShoppingBasket buildBasketWithItems(Item... items) {
		return new ShoppingBasket(List.of(items));
	}

}
