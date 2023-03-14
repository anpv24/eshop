package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;

@WebServlet(urlPatterns = { "/admin/listOrder" })

public class ListOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Order> orders = new ArrayList<Order>();
		OrderDAO OrderDAO = new OrderDAO();
		orders = OrderDAO.getAll();
		req.setAttribute("orders", orders);
		req.getRequestDispatcher("/views/admin/list-order.jsp").forward(req, resp);
	}
}
