package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.ProductSize;

public class ProductSizeDAO extends DBConnect {
	static ProductDAO productDAO = new ProductDAO();

	public static List<ProductSize> getByProductId(int productId) {
		String sql = "SELECT * FROM productSize WHERE productId=?";
		List<ProductSize> list = new ArrayList<ProductSize>();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = productDAO.getById(productId);
				ProductSize productSize = new ProductSize(rs.getInt("sizeId"), rs.getString("sizeName"), product);
				list.add(productSize);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(ProductSize productSize) {
		String sql = "INSERT INTO productSize VALUES(?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productSize.getSizeId());
			pst.setString(2, productSize.getSizeName());
			pst.setInt(3, productSize.getProduct().getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(ProductSize productSize) {
		String sql = "UPDATE productSize SET sizeId=?, sizeName=? WHERE productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productSize.getSizeId());
			pst.setString(2, productSize.getSizeName());
			pst.setInt(3, productSize.getProduct().getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int sizeId) {
		String sql = "DELETE FROM productSize WHERE colorId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sizeId);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
