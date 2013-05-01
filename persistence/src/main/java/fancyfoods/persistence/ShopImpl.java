package fancyfoods.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fancyfoods.food.Accounting;
import fancyfoods.food.Food;
import fancyfoods.food.Inventory;
import fancyfoods.food.Shop;

public class ShopImpl implements Shop {
	private Logger logger = LoggerFactory.getLogger(ShopImpl.class);
	private Inventory inventory;
	private Accounting accounting;

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setAccounting(Accounting accounting) {
		this.accounting = accounting;
	}

	@Override
	public double purchase(String foodName, String customerName, int quantity) {
		logger.info("{} is trying to purchase {}x{}...", customerName,
				quantity, foodName);
		logger.info("Getting [{}] from food inventory...", foodName);
		Food food = inventory.getFood(foodName);
		logger.info("Removing [{}] x [{}] from food inventory...", quantity, foodName);
		inventory.removeStock(foodName, quantity);
		double totalPrice = quantity * food.getPrice();
		logger.info("Charging {}'s account with ${}", customerName, totalPrice);
		accounting.chargeToAccount(customerName, totalPrice);
		return accounting.getCustomer(customerName).getBalance();
	}

}
