package fancyfoods.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fancyfoods.food.Accounting;
import fancyfoods.food.Customer;

public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 2959748140724381611L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Accounting accounting = getAccounting();
        List<Customer> customers = accounting.getCustomers();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        for (Customer c : customers) {
            out.print("<p>" + c.getName() + ", " + c.getBalance() + ", " + c.getCreditLimit() + "</p>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        BigDecimal balance = new BigDecimal(req.getParameter("balance"));
        BigDecimal creditLimit = new BigDecimal(req.getParameter("creditLimit"));
        Accounting accounting = getAccounting();
        accounting.registerCustomer(name, balance, creditLimit);

        resp.sendRedirect(req.getContextPath() + "/customer");
    }

    Accounting getAccounting() {
        try {
            InitialContext ctx = new InitialContext();
            String jndiName = "osgi:service/" + Accounting.class.getName();
            return (Accounting) ctx.lookup(jndiName);
        } catch (NamingException e) {
            throw new IllegalStateException("Accounting service is not available", e);
        }
    }

}