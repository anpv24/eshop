package controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import dao.ProductDAO;
import dao.ProductImageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Product;
import model.ProductImage;

@WebServlet(urlPatterns = { "/admin/addProductImageSub" })
@MultipartConfig
public class AddProductImageSubServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		ProductDAO dao = new ProductDAO();
		try {
			int productId = Integer.parseInt(idString);
			Product product = new Product();
			product = dao.getByIdForAdd(productId);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/views/admin/add-productImageS.jsp").forward(req, resp);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("imageS");
		String realPath = req.getServletContext().getRealPath("/views/client/images");
		String idString = req.getParameter("id");
		String imagePath = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		ProductImageDAO dao = new ProductImageDAO();
		ProductDAO dao2 = new ProductDAO();
		try {
			int productId = Integer.parseInt(idString);
			Product product = new Product();
			int isDefault = 0;
			int imageId = UUID.randomUUID().hashCode();

			part.write(realPath + "/" + imagePath);
			product = dao2.getById(productId);
			ProductImage productImage = new ProductImage(imageId, imagePath, isDefault, product);
			dao.insert(productImage);
			resp.sendRedirect("list-product");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
