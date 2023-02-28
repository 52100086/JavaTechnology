package tdtu.edu.lab4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page == null) {
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Welcome to our website");
            out.close();
        }
        String viewName = page + ".jsp";
        String viewUrl = "/pages/" + viewName;
        getServletContext().getRequestDispatcher(viewUrl).forward(request, response);
    }
}