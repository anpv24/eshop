package controller;

import java.io.IOException;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;

@WebServlet(urlPatterns = { "/admin/addc" })
public class AddCategoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		String categoryName = req.getParameter("name");
		String statusString = req.getParameter("status");
		CategoryDAO dao = new CategoryDAO();
		try {
			int categoryId = Integer.parseInt(idString);
			int status = Integer.parseInt(statusString);
			Category categoryExist = dao.getById(categoryId);
			if (categoryExist == null) {
				Category category = new Category(categoryId, categoryName, status);
				dao.insert(category);
				resp.sendRedirect("list-category");
			} else {
				req.setAttribute("error", "Mã ID: " + categoryId + " đã tồn tại");
				req.getRequestDispatcher("/admin/list-category").forward(req, resp);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}
}
