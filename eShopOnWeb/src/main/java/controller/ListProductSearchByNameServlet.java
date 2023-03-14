package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(urlPatterns = { "/searchButton" })
public class ListProductSearchByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			System.out.println(id);
			String action = request.getParameter("action");
			if (action != null) {
				if (action.equals("iphone") && id.equals("iphone")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> PIphone = productDAO.seachByName(id);
					request.setAttribute("iphone", PIphone);
					request.getRequestDispatcher("/views/client/iphone.jsp").forward(request, response);
				}
				if (action.equals("xiaomi") && id.equals("xiaomi")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> PXiaomi = productDAO.seachByName(id);
					request.setAttribute("xiaomi", PXiaomi);
					request.getRequestDispatcher("/views/client/xiaomi.jsp").forward(request, response);
				}
				if (action.equals("oppo") && id.equals("oppo")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> POppo = productDAO.seachByName(id);
					request.setAttribute("oppo", POppo);
					request.getRequestDispatcher("/views/client/oppo.jsp").forward(request, response);
				}
				if (action.equals("samsung") && id.equals("samsung")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> PSamsung = productDAO.seachByName(id);
					request.setAttribute("samsung", PSamsung);
					request.getRequestDispatcher("/views/client/samsung.jsp").forward(request, response);
				}
			}
		}
	}
}