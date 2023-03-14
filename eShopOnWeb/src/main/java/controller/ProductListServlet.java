package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(urlPatterns = { "/admin/list-product" })

public class ProductListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		ProductDAO productDAO = new ProductDAO();
		products = productDAO.getAll();
		req.setAttribute("products", products);
		req.getRequestDispatcher("/views/admin/list-product.jsp").forward(req, resp);
	}
}
