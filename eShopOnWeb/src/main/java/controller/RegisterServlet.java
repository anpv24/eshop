package controller;

import java.io.IOException;
import java.util.UUID;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet(urlPatterns = { "/client/register" })
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/client/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = UUID.randomUUID().hashCode();
		String username = req.getParameter("username").toLowerCase();
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		int isAdmin = 0;
		UserDAO dao = new UserDAO();
		User userExist = dao.getByname(username);
		if (userExist == null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", userExist);
			User user = new User(userId, username, password, fullname, null, email, phone, address, isAdmin);
			dao.insert(user);
			resp.sendRedirect(req.getContextPath() + "/client/login");
		} else {
			req.setAttribute("error", "Tài khoản: " + username + "  đã tồn tại");
			req.getRequestDispatcher("/views/client/register.jsp").forward(req, resp);
		}
	}
}
