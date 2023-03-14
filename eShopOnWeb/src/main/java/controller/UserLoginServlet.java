package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet(urlPatterns = { "/client/login" })
public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/client/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDAO userDAO = new UserDAO();
		try {
			User user2 = userDAO.getByname(username);
			User user = userDAO.login(username, password);
			if (user != null && user.getIsAdmin() == 0) {
				HttpSession session = req.getSession();
				HttpSession session2 = req.getSession();
				session.setAttribute("user", user);
				session2.setAttribute("user-detail", user2);
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				req.setAttribute("errorMsg", "Tài khoản hoặc mật khẩu sai!");
				req.getRequestDispatcher("/views/client/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
