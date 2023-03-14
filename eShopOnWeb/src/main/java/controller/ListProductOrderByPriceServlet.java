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

@WebServlet(urlPatterns = { "/searchPriceOrderBy" })
public class ListProductOrderByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getParameter("action");
			if (action != null) {
				if (action.equals("low")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> priceL = productDAO.searchByPriceLow();
					request.setAttribute("priceL", priceL);
					request.getRequestDispatcher("/views/client/price-low-to-high.jsp").forward(request, response);
				}
				if (action.equals("high")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> priceH = productDAO.searchByPriceHigh();
					request.setAttribute("priceH", priceH);
					request.getRequestDispatcher("/views/client/price-high-to-low.jsp").forward(request, response);
				}
			}
		}
	}
}
