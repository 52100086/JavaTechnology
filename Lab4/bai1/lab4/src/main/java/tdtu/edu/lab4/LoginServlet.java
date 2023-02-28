package tdtu.edu.lab4;

import java.io.*;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class LoginServlet extends HttpServlet {
    private HashMap<String, String> users = new HashMap<>();

    public LoginServlet() {
        users.put("alice", "1234");
        users.put("bob", "5678");
        users.put("charlie", "9012");
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            request.setAttribute("message", "Username/Password Match");
        } else {
            request.setAttribute("message", "Username/Password Don't Match");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}