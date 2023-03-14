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

@WebServlet(urlPatterns = { "/searchPrice" })
public class ListProductSearchByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			if (action != null) {
				if (action.equals("price") && id.equals("low")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> price1 = productDAO.seachByPrice(0, 10000000);
					request.setAttribute("price1", price1);
					request.getRequestDispatcher("/views/client/price-1.jsp").forward(request, response);
				}
				if (action.equals("price") && id.equals("middle")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> price2 = productDAO.seachByPrice(10000000, 20000000);
					request.setAttribute("price2", price2);
					request.getRequestDispatcher("/views/client/price-2.jsp").forward(request, response);
				}
				if (action.equals("price") && id.equals("high")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> price3 = productDAO.searchByPriceUp(20000000);
					request.setAttribute("price3", price3);
					request.getRequestDispatcher("/views/client/price-3.jsp").forward(request, response);
				}
			}
		}
	}
}
