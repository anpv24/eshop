package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;

@WebServlet(urlPatterns = { "/cart-check-out" })
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String payment = req.getParameter("payment");
		Date bookingDate = Date.valueOf(req.getParameter("bookingDate"));
		Date deliveryDate = Date.valueOf(req.getParameter("deliveryDate"));
		String shippingWay = req.getParameter("shippingWay");
		String color = req.getParameter("color");
		String size = req.getParameter("size");
		String note = req.getParameter("note");
		HttpSession session = req.getSession();
		try (PrintWriter out = resp.getWriter()) {
			ArrayList<Cart> cart_list = (ArrayList<Cart>) req.getSession().getAttribute("cart-list");

			// Lấy User ra từ session
			User user = (User) session.getAttribute("user");
//			User user = new User(1, "admin");

			if (cart_list != null) {
				if (user == null) {
					resp.sendRedirect("http://localhost:8080/eShopOnWeb/client/login");
				} else {
					Order order = new Order();
					// hashcode: chuyển sang số nguyên
					// UUID: sinh ra id ngẫu nhiên
					order.setOrderId(UUID.randomUUID().hashCode());
					ProductDAO pDao = new ProductDAO();
					int total = pDao.getTotalCartPrice(cart_list);
					order.setTotalMoney(total);

					order.setUser(user);
					order.setPayment(payment);
					order.setBookingDate(bookingDate);
					order.setDeliveryDate(deliveryDate);
					order.setShippingWay(shippingWay);
					order.setState(1);
					order.setColor(color);
					order.setSize(size);
					order.setNote(note);
					order.setTransportFee(0);
					// Thêm tính năng khi có liên kết với đvvc
					OrderDAO orderDAO = new OrderDAO();
					orderDAO.insert(order);

					for (Cart c : cart_list) {
						OrderDetail orderDetail = new OrderDetail();
						ProductDAO productDAO = new ProductDAO();
						Product product = productDAO.getById(c.getProductId());
						orderDetail.setOrderDetailId(UUID.randomUUID().hashCode());
						orderDetail.setProduct(product);
						orderDetail.setOrder(order);
						orderDetail.setQuantity(c.getQuantity());
						OrderDetailDAO dao = new OrderDetailDAO();
						dao.insert(orderDetail);
					}
					cart_list.clear();
					resp.sendRedirect(req.getContextPath() + "/views/client/order.jsp");
				}
			} else {
				if (user == null) {
					resp.sendRedirect(req.getContextPath() + "http://localhost:8080/eShopOnWeb/client/login");
				} else {
					resp.sendRedirect(req.getContextPath() + "/views/client/cart.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}