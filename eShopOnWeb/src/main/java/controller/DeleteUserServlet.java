package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/deleteu" })
public class DeleteUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		try {
			int userId = Integer.parseInt(idString);
			UserDAO dao = new UserDAO();
			dao.delete(userId);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/admin/listUser");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
