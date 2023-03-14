package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(urlPatterns = { "/client/updateUser" })
public class UpdateUserClientServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = (User) req.getSession().getAttribute("user-detail");
			req.setAttribute("user_detail", user);
			req.getRequestDispatcher("/views/client/user-profile.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		try {
			int userId = Integer.parseInt(idString);
			UserDAO dao = new UserDAO();
			User user = new User(userId, username, password, fullname, phone, email, address);
			dao.update(user);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/home");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
