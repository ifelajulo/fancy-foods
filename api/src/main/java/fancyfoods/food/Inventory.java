package fancyfoods.food;

import java.util.List;

import fancyfoods.api.Food;

// food inventory
public interface Inventory {

	Food getFood(String name);

	List<Food> getFoodsWhoseNameContains(String name, int maxResults);

	void createFood(String name, double price, int quantity);

	int removeStock(String name, int quantity);

	int getFoodCount();

}
