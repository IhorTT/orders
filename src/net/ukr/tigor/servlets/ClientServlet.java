package net.ukr.tigor.servlets;

import net.ukr.tigor.entity.Client;
import net.ukr.tigor.entity.Good;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static net.ukr.tigor.servlets.ContextListenerServlet.clientsDAOImlp;

public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String command = req.getParameter("command");
        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");
        String id = req.getParameter("id");

        switch (command) {
            case "Add":
                if (fullName != null && phone != null) {
                    clientsDAOImlp.add(new Client(fullName, phone));
                }
                break;
            case "Apply":
                if (id != null) {
                    clientsDAOImlp.update(new Client(Integer.parseInt(id), fullName, phone));
                }
                break;
            case "Delete":
                if (id != null) {
                    clientsDAOImlp.delete(Integer.parseInt(id));
                }
                break;
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
}
