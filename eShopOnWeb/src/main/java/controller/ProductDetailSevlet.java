package controller;

import java.io.IOException;
import java.util.List;

import dao.ProductColorDAO;
import dao.ProductDAO;
import dao.ProductDetailDAO;
import dao.ProductImageDAO;
import dao.ProductSizeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductColor;
import model.ProductDetail;
import model.ProductImage;
import model.ProductSize;

@WebServlet(urlPatterns = { "/product-detail" })
public class ProductDetailSevlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getById(id);
		ProductImageDAO dao = new ProductImageDAO();
		ProductImage imageBig = dao.getById(id);
		List<ProductImage> imageSmall = dao.getByIdForList(id);
		ProductSizeDAO sizeDAO = new ProductSizeDAO();
		List<ProductSize> productSizes = sizeDAO.getByProductId(id);
		ProductColorDAO colorDAO = new ProductColorDAO();
		List<ProductColor> productColors = colorDAO.getByProductId(id);
		ProductDetailDAO detailDAO = new ProductDetailDAO();
		ProductDetail detail = detailDAO.getById(id);
		req.setAttribute("product", product);
		req.setAttribute("imageB", imageBig);
		req.setAttribute("imageS", imageSmall);
		req.setAttribute("productS", productSizes);
		req.setAttribute("productC", productColors);
		req.setAttribute("detail", detail);
		req.getRequestDispatcher("/views/client/product-detail.jsp").forward(req, resp);

	}
}
