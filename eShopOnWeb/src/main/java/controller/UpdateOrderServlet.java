package controller;

import java.io.IOException;
import java.sql.Date;

import dao.OrderDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;
import model.User;

@WebServlet(urlPatterns = { "/admin/updateo" })
public class UpdateOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		OrderDAO dao = new OrderDAO();
		try {
			int orderId = Integer.parseInt(idString);
			Order order = new Order();
			order = dao.getById(orderId);
			req.setAttribute("order", order);
			req.getRequestDispatcher("/views/admin/updateOrder.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		String idUserString = req.getParameter("userId");
		String moneyString = req.getParameter("totalMoney");
		String payment = req.getParameter("payment");
		Date bookingDate = Date.valueOf(req.getParameter("bookingDate"));
		Date deliveryDate = Date.valueOf(req.getParameter("deliveryDate"));
		String shippingWay = req.getParameter("shippingWay");
		String stateString = req.getParameter("state");
		String color = req.getParameter("color");
		String size = req.getParameter("size");
		String note = req.getParameter("note");
		String transportFeeString = req.getParameter("transportFee");
		try {
			int orderId = Integer.parseInt(idString);
			int userId = Integer.parseInt(idUserString);
			int totalMoney = Integer.parseInt(moneyString);
			int transportFee = Integer.parseInt(transportFeeString);
			int state = Integer.parseInt(stateString);
			OrderDAO dao = new OrderDAO();
			UserDAO dao2 = new UserDAO();
			User user = dao2.getById(userId);
			Order order = new Order(orderId, totalMoney, payment, bookingDate, deliveryDate, shippingWay, state, color,
					size, note, transportFee, user);
			dao.update(order);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/admin/listOrder");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
