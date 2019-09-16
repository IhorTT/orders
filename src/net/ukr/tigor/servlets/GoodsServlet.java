package net.ukr.tigor.servlets;

import net.ukr.tigor.entity.Good;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static net.ukr.tigor.servlets.ContextListenerServlet.goodsDAOImpl;

public class GoodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String command = req.getParameter("command");
        String name = req.getParameter("name");
        String cost = req.getParameter("cost");
        String id = req.getParameter("id");
        ;
        switch (command) {
            case "Add":
                if (name != null && cost != null) {
                    goodsDAOImpl.add(new Good(name, Double.parseDouble(cost)));
                }
                break;
            case "Apply":
                if (id != null) {
                    goodsDAOImpl.update(new Good(Integer.parseInt(id), name, Double.parseDouble(cost)));
                }
                break;
            case "Delete":
                if (id != null) {
                    goodsDAOImpl.delete(Integer.parseInt(id));
                }
                break;
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
}
