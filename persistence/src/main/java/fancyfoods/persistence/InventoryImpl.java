package fancyfoods.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fancyfoods.food.Food;
import fancyfoods.food.Inventory;

public class InventoryImpl implements Inventory {

	private Logger logger = LoggerFactory.getLogger(InventoryImpl.class);

	private EntityManager em;

	@Override
	public FoodImpl getFood(String name) {
		return em.find(FoodImpl.class, name);
	}

	@Override
	public void createFood(String name, double price, int quantity) {
		FoodImpl food = new FoodImpl(name, price, quantity);
		em.persist(food);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getFoodsWhoseNameContains(String name, int maxResults) {
		String query = "SELECT f FROM FOOD f WHERE f.name LIKE '%" + name
				+ "%' ORDER BY f.quantity DESC";
		Query q = em.createQuery(query);
		q.setMaxResults(maxResults);
		return q.getResultList();
	}

	@Override
	public int getFoodCount() {
		Query query = em.createQuery("SELECT COUNT(f) FROM FOOD f");
		Number count = (Number) query.getSingleResult();
		return count.intValue();
	}

	@Override
	public int removeStock(String name, int quantity) {
		FoodImpl food = getFood(name);
		int currentLevel = food.getQuantityInStock();
		int newLevel = currentLevel - quantity;
		if (newLevel >= 0) {
			logger.debug("Updating quatity of [{}] from [{}] to [{}]..", name,
					currentLevel, newLevel);
			food.setQuantityInStock(newLevel);
			em.persist(food);
			return newLevel;
		} else {
			throw new IllegalArgumentException("Cannot have level below 0: "
					+ newLevel);
		}
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
