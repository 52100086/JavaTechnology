package tdtu.edu.lab5.Servlet;

import tdtu.edu.lab5.dao.UserDAO;
import tdtu.edu.lab5.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("flash_message", "Invalid username or password");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String remember = request.getParameter("check1");

            if (remember != null && remember.equals("remember")) {

                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(usernameCookie);

                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(passwordCookie);
            }
            response.sendRedirect("jsp/index.jsp");
        }
    }
}
