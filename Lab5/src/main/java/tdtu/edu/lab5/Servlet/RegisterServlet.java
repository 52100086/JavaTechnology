package tdtu.edu.lab5.Servlet;

import tdtu.edu.lab5.dao.UserDAO;
import tdtu.edu.lab5.model.User;
import tdtu.edu.lab5.utils.HibernateUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String confirm_password = request.getParameter("password-confirm");
        if(password.length() < 6) {
            request.setAttribute("errorMessage", "Password must be at least 6 characters.");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
            return;
        }
        if(!confirm_password.equals(password)){
            request.setAttribute("falsePassword", "Your passwords are not the same");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
            return;
        }

        User user = new User(name, password, email);
        userDAO.createUser(user);

        response.sendRedirect(request.getContextPath() + "/login");
    }

}
