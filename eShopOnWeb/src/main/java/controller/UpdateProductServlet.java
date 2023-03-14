package controller;

import java.io.IOException;

import dao.CategoryDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(urlPatterns = { "/admin/updatep" })
public class UpdateProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		ProductDAO dao = new ProductDAO();
		try {
			int productId = Integer.parseInt(idString);
			Product product = new Product();
			product = dao.getByIdForAdd(productId);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/views/admin/updateProduct.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		String productName = req.getParameter("name");
		String priceString = req.getParameter("price");
		String opriceString = req.getParameter("originalPrice");
		String description = req.getParameter("description");
		String statusString = req.getParameter("status");
		String categoryIdString = req.getParameter("categoryId");
		try {
			CategoryDAO category = new CategoryDAO();
			int productId = Integer.parseInt(idString);
			int price = Integer.parseInt(priceString);
			int originalPrice = Integer.parseInt(opriceString);
			int status = Integer.parseInt(statusString);
			int categoryId = Integer.parseInt(categoryIdString);
			ProductDAO dao = new ProductDAO();
			Product product = new Product(productId, productName, price, originalPrice, description, status,
					category.getById(categoryId));
			dao.update(product);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/admin/list-product");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}
}
