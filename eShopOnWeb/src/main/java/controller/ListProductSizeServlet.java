package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductSizeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductSize;

@WebServlet(urlPatterns = { "/admin/list-productSize" })
public class ListProductSizeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductSize> list = new ArrayList<ProductSize>();
		ProductSizeDAO dao = new ProductSizeDAO();
		String idString = req.getParameter("id");
		try {
			int productId = Integer.parseInt(idString);
			list = dao.getByProductId(productId);
			req.setAttribute("ProductSize", list);
			req.getRequestDispatcher("/views/admin/list-size.jsp").forward(req, resp);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
