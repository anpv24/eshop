package controller;

import java.io.IOException;

import dao.ProductSizeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/deleteProductSize" })
public class DeleteProductSizeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		try {
			int sizeId = Integer.parseInt(idString);
			ProductSizeDAO dao = new ProductSizeDAO();
			dao.delete(sizeId);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/admin/list-product");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
