package controller;

import java.io.IOException;

import dao.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin/deleteo" })
public class DeleteOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		try {
			int orderId = Integer.parseInt(idString);
			OrderDAO dao = new OrderDAO();
			dao.delete(orderId);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/admin/listOrder");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
