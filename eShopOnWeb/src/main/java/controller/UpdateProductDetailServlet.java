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

@WebServlet(urlPatterns = { "/admin/updatep-detail" })
public class UpdateProductDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		ProductDetailDAO dao = new ProductDetailDAO();
		try {
			int productId = Integer.parseInt(idString);
			ProductDetail productDetail = new ProductDetail();
			productDetail = dao.getById(productId);
			req.setAttribute("productDetail", productDetail);
			req.getRequestDispatcher("/views/admin/updateProductDetail.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			ProductDetail productDetail = new ProductDetail(monitor, os, rearCamera, frontCamera, chip, ram, rom, sim,
					battery, charge, product);
			dao2.update(productDetail);
			resp.sendRedirect("http://localhost:8080/eShopOnWeb/admin/list-product");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}
}
