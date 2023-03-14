package controller;

import java.io.IOException;

import dao.CategoryDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

@WebServlet(urlPatterns = { "/admin/addp" })
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		String productName = req.getParameter("name");
		String priceString = req.getParameter("price");
		String opriceString = req.getParameter("originalPrice");
		String description = req.getParameter("description");
		String statusString = req.getParameter("status");
		String categoryIdString = req.getParameter("categoryId");
		ProductDAO dao = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		try {
			int productId = Integer.parseInt(idString);
			int price = Integer.parseInt(priceString);
			int originalPrice = Integer.parseInt(opriceString);
			int status = Integer.parseInt(statusString);
			int categoryId = Integer.parseInt(categoryIdString);
			Product productExist = dao.getByIdForAdd(productId);
			Category category = new Category();
			category = categoryDAO.getById(categoryId);
			if (productExist == null) {
				Product product = new Product(productId, productName, price, originalPrice, description, status,
						category);
				dao.insert(product);
				resp.sendRedirect("list-product");
			} else {
				req.setAttribute("error", "Mã ID: " + productId + " đã tồn tại");
				req.getRequestDispatcher("/admin/list-product").forward(req, resp);
//				/views/admin/listProduct.jsp
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}
}
