package controller;

import java.io.IOException;
import java.util.UUID;

import dao.ProductDAO;
import dao.ProductSizeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductSize;

@WebServlet(urlPatterns = { "/admin/addProductSize" })
public class AddProductSizeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		try {
			int productId = Integer.parseInt(req.getParameter("id"));
			Product product = new Product();
			product = dao.getByIdForAdd(productId);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/views/admin/add-productSize.jsp").forward(req, resp);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductSizeDAO dao = new ProductSizeDAO();
		ProductDAO dao2 = new ProductDAO();
		String sizeName = req.getParameter("sizeName");
		try {
			int productId = Integer.parseInt(req.getParameter("id"));
			Product product = new Product();
			int sizeId = UUID.randomUUID().hashCode();
			product = dao2.getById(productId);
			ProductSize productSize = new ProductSize(sizeId, sizeName, product);
			dao.insert(productSize);
			resp.sendRedirect("list-product");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
