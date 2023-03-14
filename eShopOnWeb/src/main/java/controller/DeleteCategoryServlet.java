package controller;

import java.io.IOException;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/deletec" })
public class DeleteCategoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		try {
			int categoryId = Integer.parseInt(idString);
			CategoryDAO dao = new CategoryDAO();
			dao.delete(categoryId);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/admin/list-category");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
