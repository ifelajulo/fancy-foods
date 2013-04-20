package fancyfoods.offers;

import fancyfoods.api.Food;

public interface SpecialOffer {
	Food getOfferFood();

	String getDescription();
}
