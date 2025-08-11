package com.example.Cwiczenie_Service_z_cache;

import com.example.Cwiczenie_Service_z_cache.model.Category;
import com.example.Cwiczenie_Service_z_cache.model.Product;
import com.example.Cwiczenie_Service_z_cache.repository.impl.InMemoryProductRepository;
import com.example.Cwiczenie_Service_z_cache.service.ProductService;
import com.example.Cwiczenie_Service_z_cache.service.impl.ProductServiceImpl;

import java.math.BigDecimal;

import static com.example.Cwiczenie_Service_z_cache.model.Category.*;

/*
	Mając klasę Product zawierającą nazwę, cenę oraz kategorię (FRUIT, VEGETABLE):
	 -> Pogrupuj wszystkie produkty wg kategorii
	 -> Oblicz średnią cenę produktów podanej kategorii.
	 -> Znajdź najdroższe produkty w każdej kategorii (uwzględnij, że może być ich więcej niż jeden).
	 Wymagania:
	 -> Dane pobieraj z repozytorium implementującego interfejs ProductRepository.
	 -> Opieraj się na interfejsie ProductService
	 Założenie:
	 -> Pula danych zawsze jest taka sama.
 */
public class CwiczenieServiceZCacheApplication {

	public static void main(String[] args) {

		InMemoryProductRepository productRepository = new InMemoryProductRepository();
		ProductService productService = new ProductServiceImpl(productRepository, false); // regulujemy czy używamy cache czy nie

		System.out.println("------------------------[1]---------------------------");
//		productService.calculateAveragePriceByCategory(FRUIT).ifPresent(System.out::println);
//		productRepository.addProduct(new Product("STRAWBERRY", new BigDecimal("10"), FRUIT));
//		productService.calculateAveragePriceByCategory(FRUIT).ifPresent(System.out::println);


		System.out.println("------------------------[2.1]---------------------------");
//		productService.getProductsGroupedByCategory().forEach(((category, products) -> {
//			System.out.println(category);
//			System.out.println(products);
//		}));
//		productRepository.addProduct(new Product("STRAWBERRY", new BigDecimal("10"), FRUIT));
		System.out.println("------------------------[2.2]---------------------------");
//		productService.getProductsGroupedByCategory().forEach(((category, products) -> {
//			System.out.println(category);
//			System.out.println(products);
//		}));


		System.out.println("------------------------[3.1]---------------------------");
//		productService.getProductsPartitionedByVegetable().forEach(((category, products) -> {
//			System.out.println(category);
//			System.out.println(products);
//		}));
//		productRepository.addProduct(new Product("STRAWBERRY", new BigDecimal("10"), FRUIT));
		System.out.println("------------------------[3.2]---------------------------");
//		productService.getProductsPartitionedByVegetable().forEach(((category, products) -> {
//			System.out.println(category);
//			System.out.println(products);
//		}));


		System.out.println("------------------------[4.1]---------------------------");
		productService.findMostExpensiveProductsByCategory().forEach(((category, products) -> {
			System.out.println(category);
			System.out.println(products);
		}));
		productRepository.addProduct(new Product("STRAWBERRY", new BigDecimal("45"), FRUIT));
		System.out.println("------------------------[4.2]---------------------------");
		productService.findMostExpensiveProductsByCategory().forEach(((category, products) -> {
			System.out.println(category);
			System.out.println(products);
		}));
	}

}
