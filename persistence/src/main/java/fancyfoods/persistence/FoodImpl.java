package fancyfoods.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

import fancyfoods.api.Food;

@Entity(name = "FOOD")
public class FoodImpl implements Food {

	@Id
	private String name;
	private double price;
	private int quantity;

	public FoodImpl() {
	}

	public FoodImpl(String name, double price, int quantity) {
		this();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int getQuantityInStock() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
