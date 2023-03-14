package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(urlPatterns = { "/admin/listUser" })
public class ListUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = new ArrayList<User>();
		UserDAO dao = new UserDAO();
		users = dao.getAllUser();
		req.setAttribute("users", users);
		req.getRequestDispatcher("/views/admin/list-user.jsp").forward(req, resp);
	}
}
