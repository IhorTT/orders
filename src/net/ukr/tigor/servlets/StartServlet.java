package net.ukr.tigor.servlets;

import net.ukr.tigor.entity.Client;
import net.ukr.tigor.entity.Good;
import net.ukr.tigor.entity.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static net.ukr.tigor.servlets.ContextListenerServlet.clientsDAOImlp;
import static net.ukr.tigor.servlets.ContextListenerServlet.goodsDAOImpl;
import static net.ukr.tigor.servlets.ContextListenerServlet.ordersDAOImpl;

@WebServlet("/index.jsp")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> ordersList = ordersDAOImpl.getAll();
        if (ordersList.size() == 0) {
            getSomeDataAtStart();
            ordersList = ordersDAOImpl.getAll();
        }
        req.setAttribute("lstOrders", ordersList);

        List<Good> goodsList = goodsDAOImpl.getAll(Good.class);
        req.setAttribute("lstGoods", goodsList);

        List<Client> clientsList = clientsDAOImlp.getAll(Client.class);
        req.setAttribute("lstClients", clientsList);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        rd.forward(req, resp);
    }

    private void getSomeDataAtStart() {

        Good g1 = new Good(1, "bread", 10, 1);
        Good g2 = new Good(2, "butter", 25, 1);
        Good g3 = new Good(3, "milk", 15, 1);
        Good g4 = new Good(4, "meat", 140, 1);

        goodsDAOImpl.add(g1);
        goodsDAOImpl.add(g2);
        goodsDAOImpl.add(g3);
        goodsDAOImpl.add(g4);

        Client cl1 = new Client("T. Ihor", "380112223344");
        cl1.setId(1);
        Client cl2 = new Client("V. Vasya", "380112223345");
        Client cl3 = new Client("I. Ivan", "380112223346");

        clientsDAOImlp.add(cl1);
        clientsDAOImlp.add(cl2);
        clientsDAOImlp.add(cl3);

        Order order = new Order(1, LocalDate.now(), cl1, 0);
        order.addGood(g1);
        order.addGood(g2);
        order.addGood(g3);
        ordersDAOImpl.add(order);
    }

}


