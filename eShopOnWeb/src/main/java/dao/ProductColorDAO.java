package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.ProductColor;

public class ProductColorDAO extends DBConnect {
	static ProductDAO productDAO = new ProductDAO();

	public static List<ProductColor> getByProductId(int productId) {
		String sql = "SELECT * FROM productColor WHERE productId=?";
		List<ProductColor> list = new ArrayList<ProductColor>();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = productDAO.getById(productId);
				ProductColor productColor = new ProductColor(rs.getInt("colorId"), rs.getString("colorName"), product);
				list.add(productColor);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(ProductColor productColor) {
		String sql = "INSERT INTO productColor VALUES(?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productColor.getColorId());
			pst.setString(2, productColor.getColorName());
			pst.setInt(3, productColor.getProduct().getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(ProductColor productColor) {
		String sql = "UPDATE productColor SET colorId=?, colorName=? WHERE productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productColor.getColorId());
			pst.setString(2, productColor.getColorName());
			pst.setInt(3, productColor.getProduct().getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int colorId) {
		String sql = "DELETE FROM productImage WHERE colorId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, colorId);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
