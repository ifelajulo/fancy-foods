package fancyfoods.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fancyfoods.food.Food;
import fancyfoods.offers.CurrentOffers;
import fancyfoods.offers.SpecialOffer;

@SuppressWarnings("serial")
public class SayHelloJNDI extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter html = response.getWriter();
		html.println("<html>");
		html.println("Hello valued customer!<br/>");
		try {
			InitialContext ctx = new InitialContext();
			String jndiName = "osgi:service/" + CurrentOffers.class.getName();
			CurrentOffers offers = (CurrentOffers) ctx.lookup(jndiName);
			html.println("<table>");
			List<SpecialOffer> currentOffers = offers.getCurrentOffers();
			for (SpecialOffer offer : currentOffers) {
				writeRowForOffer(html, offer);
			}
			html.println("</table>");
		} catch (NamingException e) {
			html.println("We have no special offers today. "
					+ "Try again tomorrow.");
		}
		html.println("</html>");
	}

	private void writeRowForOffer(PrintWriter html, SpecialOffer offer) {
		html.println("<tr>");
		String description = offer.getDescription();
		Food offerFood = offer.getOfferFood();
		html.println("<td>" + offerFood.getName() + "</td>");
		html.println("<td>" + offerFood.getPrice() + "</td>");
		html.println("<td>" + description + "</td>");
		html.println("</tr>");
	}

}
