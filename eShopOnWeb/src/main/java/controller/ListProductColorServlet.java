package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductColorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductColor;

@WebServlet(urlPatterns = { "/admin/list-productColor" })
public class ListProductColorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductColor> list = new ArrayList<ProductColor>();
		String idString = req.getParameter("id");
		ProductColorDAO dao = new ProductColorDAO();
		try {
			int productId = Integer.parseInt(idString);
			list = dao.getByProductId(productId);
			req.setAttribute("ProductColor", list);
			req.getRequestDispatcher("/views/admin/list-color.jsp").forward(req, resp);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
