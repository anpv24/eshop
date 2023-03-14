package controller;

import java.io.IOException;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;

@WebServlet(urlPatterns = { "/admin/updatec" })
public class UpdateCategoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		CategoryDAO dao = new CategoryDAO();
		try {
			int productId = Integer.parseInt(idString);
			Category category = new Category();
			category = dao.getById(productId);
			req.setAttribute("category", category);
			req.getRequestDispatcher("/views/admin/updateCategory.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		String categoryName = req.getParameter("name");
		String statusString = req.getParameter("status");
		try {
			int categoryId = Integer.parseInt(idString);
			int status = Integer.parseInt(statusString);
			CategoryDAO dao = new CategoryDAO();
			Category category = new Category(categoryId, categoryName, status);
			dao.update(category);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/admin/list-category");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
