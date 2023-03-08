package tdtu.edu.lab5.Servlet;

import tdtu.edu.lab5.dao.ProductDAO;
import tdtu.edu.lab5.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
        List<Product> products = productDAO.getAll();
        getServletContext().setAttribute("products", products);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        request.setAttribute("username", username);
        List<Product> products = productDAO.getAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Vui lòng nhập tên sản phẩm");
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        } else {
            String action = request.getParameter("action");
            if (action != null && action.equals("delete")) {
                int productId = Integer.parseInt(request.getParameter("id"));
                productDAO.delete(productId);
            } else {
                Product product = new Product(name, price);
                productDAO.create(product);
            }
            response.sendRedirect(request.getContextPath() + "/product");
        }
    }
}
