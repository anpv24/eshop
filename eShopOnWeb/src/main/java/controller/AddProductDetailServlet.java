package controller;

import java.io.IOException;

import dao.ProductDAO;
import dao.ProductDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductDetail;

@WebServlet(urlPatterns = { "/admin/addp-detail" })
public class AddProductDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		String monitor = req.getParameter("monitor");
		String os = req.getParameter("os");
		String rearCamera = req.getParameter("rearCamera");
		String frontCamera = req.getParameter("frontCamera");
		String chip = req.getParameter("chip");
		String ram = req.getParameter("ram");
		String rom = req.getParameter("rom");
		String sim = req.getParameter("sim");
		String battery = req.getParameter("battery");
		String charge = req.getParameter("charge");
		ProductDAO dao = new ProductDAO();
		ProductDetailDAO dao2 = new ProductDetailDAO();
		try {
			int productId = Integer.parseInt(idString);
			Product product = new Product();
			product = dao.getById(productId);
			ProductDetail productDetailExist = dao2.getByIdForAdd(productId);
			if (productDetailExist == null) {
				ProductDetail productDetail = new ProductDetail(monitor, os, rearCamera, frontCamera, chip, ram, rom,
						sim, battery, charge, product);
				dao2.insert(productDetail);
				resp.sendRedirect("list-product");
			} else {
				req.setAttribute("error2",
						"Mã ID: " + productId + " đã tồn tại thông tin chi tiết, vui lòng chọn sửa!");
				req.getRequestDispatcher("/admin/list-product").forward(req, resp);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
	}
}
