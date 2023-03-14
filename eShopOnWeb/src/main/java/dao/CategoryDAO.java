package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAO extends DBConnect {
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM category";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Category category = new Category(rs.getInt("categoryId"), rs.getString("categoryName"),
						rs.getInt("status"));
				categories.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	public int count() {
		String sql = "select count(*) from category";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Category getById(int categoryId) {
		String sql = "SELECT * FROM category WHERE categoryId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, categoryId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Category category = new Category(rs.getInt("categoryId"), rs.getString("categoryName"),
						rs.getInt("status"));
				return category;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Category category) {
		String sql = "INSERT INTO category VALUES(?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, category.getCategoryId());
			pst.setString(2, category.getCategoryName());
			pst.setInt(3, category.getStatus());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(Category category) {
		String sql = "UPDATE category SET categoryName=?,status=? WHERE categoryId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, category.getCategoryName());
			pst.setInt(2, category.getStatus());
			pst.setInt(3, category.getCategoryId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int categoryId) {
		String sql = "DELETE FROM category WHERE categoryId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, categoryId);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getCidByProductId(int productId) {
		String sql = "SELECT category.categoryId AS categoryId FROM product "
				+ "INNER JOIN category ON product.categoryId = category.categoryId " + "WHERE product.productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt("categoryId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productId;
	}
}
