package fancyfoods.chocolate;

import java.util.Calendar;

import fancyfoods.food.Food;
import fancyfoods.offers.SpecialOffer;

public class RomanticChocolateOffer implements SpecialOffer {
	
	class HeartShapedChocolates implements Food {
		@Override
		public String getName() {
			return "Heart Shaped Chocolates";
		}
		@Override
		public double getPrice() {
			return 14.0;
		}
		@Override
		public int getQuantityInStock() {
			return 15;
		}
	}
	class SquareChocolates implements Food {
		@Override
		public String getName() {
			return "Square Chocolate";
		}
		@Override
		public double getPrice() {
			return 12.0;
		}
		@Override
		public int getQuantityInStock() {
			return 20;
		}
	}
	@Override
	public String getDescription() {
		return "A wonderful surprise for someone you want to impress.";
	}

	@Override
	public Food getOfferFood() {
		if (isNearValentinesDay()) {
			return new HeartShapedChocolates();
		} else {
			return new SquareChocolates();
		}
	}

	private boolean isNearValentinesDay() {
		Calendar today = Calendar.getInstance();
		return today.get(Calendar.MONTH) == Calendar.FEBRUARY
				&& today.get(Calendar.DAY_OF_MONTH) <= 14;
	}
}
