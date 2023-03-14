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

@WebServlet(urlPatterns = { "/iphoneOrder" })
public class ListIphoneOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			String iphone = "iphone";
			if (action != null) {
				// Phân trang theo giá cao <-> thấp Iphone
				if (action.equals("price") && id.equals("low")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphoneL = productDAO.searchProductByPriceLow(iphone);
					request.setAttribute("iphoneL", iphoneL);
					request.getRequestDispatcher("/views/client/iphone-price-low-to-high.jsp").forward(request,
							response);
				}
				if (action.equals("price") && id.equals("high")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphoneH = productDAO.searchProductByPriceHigh(iphone);
					request.setAttribute("iphoneH", iphoneH);
					request.getRequestDispatcher("/views/client/iphone-price-high-to-low.jsp").forward(request,
							response);
				}

				// Phân trang theo khoảng giá Iphone
				if (action.equals("price") && id.equals("min")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone1 = productDAO.searchByNameAndPrice(iphone, 0, 10000000);
					request.setAttribute("iphone1", iphone1);
					request.getRequestDispatcher("/views/client/iphone-price-1.jsp").forward(request, response);
				}
				if (action.equals("price") && id.equals("middle")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone2 = productDAO.searchByNameAndPrice(iphone, 10000000, 20000000);
					request.setAttribute("iphone2", iphone2);
					request.getRequestDispatcher("/views/client/iphone-price-2.jsp").forward(request, response);
				}
				if (action.equals("price") && id.equals("max")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone3 = productDAO.searchByNameAndPriceUp(iphone, 20000000);
					request.setAttribute("iphone3", iphone3);
					request.getRequestDispatcher("/views/client/iphone-price-3.jsp").forward(request, response);
				}

				// Phân trang giá thấp- cao -iphone
				if (action.equals("price") && id.equals("lowlow")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone1_L = productDAO.searchByNameS3L(iphone, 0, 10000000);
					request.setAttribute("iphone1_L", iphone1_L);
					request.getRequestDispatcher("/views/client/iphone-price-1-low-to-high.jsp").forward(request,
							response);
				}
				if (action.equals("price") && id.equals("lowmiddle")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone2_L = productDAO.searchByNameS3L(iphone, 10000000, 20000000);
					request.setAttribute("iphone2_L", iphone2_L);
					request.getRequestDispatcher("/views/client/iphone-price-2-low-to-high.jsp").forward(request,
							response);
				}
				if (action.equals("price") && id.equals("lowhigh")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone3_L = productDAO.searchByNameS3UpL(iphone, 20000000);
					request.setAttribute("iphone3_L", iphone3_L);
					request.getRequestDispatcher("/views/client/iphone-price-3-low-to-high.jsp").forward(request,
							response);
				}

				// Phân trang giá cao- thấp -iphone
				if (action.equals("price") && id.equals("highlow")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone1_H = productDAO.searchByNameS3H(iphone, 0, 10000000);
					request.setAttribute("iphone1_H", iphone1_H);
					request.getRequestDispatcher("/views/client/iphone-price-1-high-to-low.jsp").forward(request,
							response);
				}
				if (action.equals("price") && id.equals("highmiddle")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone2_H = productDAO.searchByNameS3H(iphone, 10000000, 20000000);
					request.setAttribute("iphone2_H", iphone2_H);
					request.getRequestDispatcher("/views/client/iphone-price-2-high-to-low.jsp").forward(request,
							response);
				}
				if (action.equals("price") && id.equals("highhigh")) {
					ProductDAO productDAO = new ProductDAO();
					List<Product> iphone3_H = productDAO.searchByNameS3UpH(iphone, 20000000);
					request.setAttribute("iphone3_H", iphone3_H);
					request.getRequestDispatcher("/views/client/iphone-price-3-high-to-low.jsp").forward(request,
							response);
				}
			}
		}
	}
}
