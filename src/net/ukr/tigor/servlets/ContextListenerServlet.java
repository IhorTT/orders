package net.ukr.tigor.servlets;

import net.ukr.tigor.daoService.ClientsDAOImlp;
import net.ukr.tigor.daoService.ConnectionFactory;
import net.ukr.tigor.daoService.GoodsDAOImlp;
import net.ukr.tigor.daoService.OrdersDAOImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class ContextListenerServlet implements ServletContextListener {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Kiev";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public static GoodsDAOImlp goodsDAOImpl;
    public static ClientsDAOImlp clientsDAOImlp;
    public static OrdersDAOImpl ordersDAOImpl;


    @Override
    public void contextInitialized(ServletContextEvent arg0) {

        Connection conn = new ConnectionFactory(URL, USER, PASSWORD).getConnection();

        goodsDAOImpl = new GoodsDAOImlp(conn, "Goods");
        goodsDAOImpl.initBD();

        clientsDAOImlp = new ClientsDAOImlp(conn, "Clients");
        clientsDAOImlp.initBD();

        ordersDAOImpl = new OrdersDAOImpl(conn, "Orders");
        ordersDAOImpl.initBD();
    }
}
