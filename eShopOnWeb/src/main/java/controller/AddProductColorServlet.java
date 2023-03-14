package controller;

import java.io.IOException;
import java.util.UUID;

import dao.ProductColorDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductColor;

@WebServlet(urlPatterns = { "/admin/addProductColor" })
public class AddProductColorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		try {
			int productId = Integer.parseInt(req.getParameter("id"));
			Product product = new Product();
			product = dao.getByIdForAdd(productId);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/views/admin/add-productColor.jsp").forward(req, resp);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductColorDAO dao = new ProductColorDAO();
		ProductDAO dao2 = new ProductDAO();
		String colorName = req.getParameter("colorName");
		try {
			int productId = Integer.parseInt(req.getParameter("id"));
			Product product = new Product();
			int colorId = UUID.randomUUID().hashCode();
			product = dao2.getById(productId);
			ProductColor productColor = new ProductColor(colorId, colorName, product);
			dao.insert(productColor);
			resp.sendRedirect("list-product");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
