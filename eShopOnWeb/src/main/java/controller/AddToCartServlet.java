package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;

@WebServlet(urlPatterns = { "/add-to-cart" })
public class AddToCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<Cart>();

			int id = Integer.parseInt(req.getParameter("id"));
			Cart cm = new Cart();
			cm.setProductId(id);
			cm.setQuantity(1);

			HttpSession session = req.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

			if (cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				cartList = cart_list;
				boolean exist = false;
				cartList.contains(cm);

				for (Cart c : cart_list) {
					if (c.getProductId() == id) {
						exist = true;
						out.println(
								"<h3 style='color: red;text-align:center;'>Item already exist in cart <a href='/eShopOnWeb/views/client/cart.jsp'>Go to cart page</a></h3>");
					}
				}
				if (!exist) {
					cartList.add(cm);
					resp.sendRedirect(req.getContextPath() + "/home");
				}
			}
		}
	}
}
