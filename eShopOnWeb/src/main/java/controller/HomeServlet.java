package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import dao.ProductImageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductImage;

@WebServlet(urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		ProductDAO productDAO = new ProductDAO();
		products = productDAO.getAll();

		List<ProductImage> images = new ArrayList<ProductImage>();
		ProductImageDAO imageDAO = new ProductImageDAO();
		images = imageDAO.getAll();

		req.setAttribute("products", products);
		req.setAttribute("images", images);
		req.getRequestDispatcher("/views/client/index.jsp").forward(req, resp);
	}
}
