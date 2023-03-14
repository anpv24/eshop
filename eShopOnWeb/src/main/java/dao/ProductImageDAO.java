package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.ProductImage;

public class ProductImageDAO extends DBConnect {
	static ProductDAO productDAO = new ProductDAO();

	public List<ProductImage> getAll() {
		List<ProductImage> list = new ArrayList<ProductImage>();
		String sql = "SELECT * FROM productImage";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Product product = productDAO.getById(rs.getInt("productId"));
				ProductImage productImage = new ProductImage(rs.getInt("imageId"), rs.getString("imagePath"),
						rs.getInt("isDefault"), product);
				list.add(productImage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static ProductImage getById(int productId) {

		String sql = "SELECT * FROM productImage WHERE productId=? AND isDefault = 1";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Product product = productDAO.getById(productId);
				ProductImage productImage = new ProductImage(rs.getInt("imageId"), rs.getString("imagePath"),
						rs.getInt("isDefault"), product);
				return productImage;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ProductImage getByProductId(int productId) {

		String sql = "SELECT * FROM productImage WHERE productId=? AND isDefault = 1";
		ProductDAO dao = new ProductDAO();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Product product = dao.getById(productId);
				ProductImage productImage = new ProductImage(rs.getInt("imageId"), rs.getString("imagePath"),
						rs.getInt("isDefault"), product);
				return productImage;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<ProductImage> getByIdForList(int productId) {
		String sql = "SELECT * FROM productImage WHERE productId=? AND isDefault = 0";
		List<ProductImage> list = new ArrayList<ProductImage>();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = productDAO.getById(productId);
				ProductImage productImage = new ProductImage(rs.getInt("imageId"), rs.getString("imagePath"),
						rs.getInt("isDefault"), product);
				list.add(productImage);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<ProductImage> getCartImageProducts(ArrayList<ProductImage> cartList) {
		List<ProductImage> image = new ArrayList<>();
		try {
			if (cartList.size() > 0) {
				for (ProductImage item : cartList) {
					String sql = "select * from productImage where productId=? and isDefault=1";
					PreparedStatement pst = conn.prepareStatement(sql);
					pst.setInt(1, item.getProduct().getProductId());
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						Product product = productDAO.getById(rs.getInt("productId"));
						ProductImage productImage = new ProductImage();
						productImage.setImageId(rs.getInt("imageId"));
						productImage.setImagePath(rs.getString("imagePath"));
						productImage.setIsDefault(rs.getInt("isAdmin"));
						productImage.setProduct(product);
						image.add(productImage);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return image;
	}

	public void insert(ProductImage productImage) {
		String sql = "INSERT INTO productImage VALUES(?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productImage.getImageId());
			pst.setString(2, productImage.getImagePath());
			pst.setInt(3, productImage.getIsDefault());
			pst.setInt(4, productImage.getProduct().getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(ProductImage productImage) {
		String sql = "UPDATE productImage SET imageId=?, imagePath=? WHERE productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productImage.getImageId());
			pst.setString(2, productImage.getImagePath());
			pst.setInt(3, productImage.getProduct().getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int imageId) {
		String sql = "DELETE FROM productImage WHERE imageId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, imageId);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
