package fancyfoods.offers.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fancyfoods.offers.CurrentOffers;
import fancyfoods.offers.SpecialOffer;

public class OfferAgregator implements CurrentOffers {

	private static final int MAX_OFFERS = 4;
	private List<SpecialOffer> offers;

	public void setOffers(List<SpecialOffer> offers) {
		this.offers = offers;
	}

	@Override
	public List<SpecialOffer> getCurrentOffers() {
		List<SpecialOffer> sortedOffers = new ArrayList<SpecialOffer>(offers);
		Collections.sort(sortedOffers, new OfferComparator());
		int offerCount = Math.min(MAX_OFFERS, sortedOffers.size());
		return sortedOffers.subList(0, offerCount);
	}

	private static class OfferComparator implements Comparator<SpecialOffer> {
		@Override
		public int compare(SpecialOffer offer1, SpecialOffer offer2) {
			return ((Double) offer2.getOfferFood().getPrice()).compareTo(offer1
					.getOfferFood().getPrice());
		}
	}

}
