package fancyfoods.web;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.XADataSource;

// for testing datasource
public class DataSourceServlet extends HttpServlet {

    private static final long serialVersionUID = 535913792447252392L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext ctx = new InitialContext();
            XADataSource dataSource = (XADataSource) ctx.lookup("osgi:service/jdbc/xafancyfoodsdb");
            System.out.println(dataSource.getXAConnection());
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
