package net.ukr.tigor.servlets;

import net.ukr.tigor.entity.Good;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static net.ukr.tigor.servlets.ContextListenerServlet.goodsDAOImpl;

public class Service extends HttpServlet {

     public static void sendResponse(HttpServletRequest req, HttpServletResponse resp, ServletContext servCont) {
        List<Good> goodsList = goodsDAOImpl.getAll(Good.class);
        req.setAttribute("apartments", 1);
        req.setAttribute("auto", 1);
        RequestDispatcher rd = servCont.getRequestDispatcher("/index.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
