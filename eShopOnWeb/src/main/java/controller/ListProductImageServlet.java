package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductImageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductImage;

@WebServlet(urlPatterns = { "/admin/list-productImage" })
public class ListProductImageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductImage productImage = new ProductImage();
		List<ProductImage> list2 = new ArrayList<ProductImage>();
		ProductImageDAO dao = new ProductImageDAO();
		String idString = req.getParameter("id");
		try {
			int productId = Integer.parseInt(idString);
			productImage = dao.getById(productId);
			list2 = dao.getByIdForList(productId);
			req.setAttribute("imageM", productImage);
			req.setAttribute("imageS", list2);
			req.getRequestDispatcher("/views/admin/list-image.jsp").forward(req, resp);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
