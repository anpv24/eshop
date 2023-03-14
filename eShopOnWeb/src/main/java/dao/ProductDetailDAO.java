package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;
import model.ProductDetail;

public class ProductDetailDAO extends DBConnect {
	ProductDAO productDAO = new ProductDAO();

	public ProductDetail getById(int productId) {
		String sql = "SELECT * FROM product_detail WHERE productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Product product = productDAO.getById(productId);
				ProductDetail productDetail = new ProductDetail(rs.getString("monitor"), rs.getString("os"),
						rs.getString("rearCamera"), rs.getString("frontCamera"), rs.getString("chip"),
						rs.getString("ram"), rs.getString("rom"), rs.getString("sim"), rs.getString("battery"),
						rs.getString("charge"), product);
				return productDetail;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ProductDetail getByIdForAdd(int productId) {
		String sql = "SELECT monitor,os,rearCamera,frontCamera,chip,ram,rom,sim,battery,charge FROM product_detail WHERE productId=?";
		try {
			ProductDAO dao = new ProductDAO();
			Product product = new Product();
			product = dao.getById(productId);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				ProductDetail productDetail = new ProductDetail(rs.getString("monitor"), rs.getString("os"),
						rs.getString("rearCamera"), rs.getString("frontCamera"), rs.getString("chip"),
						rs.getString("ram"), rs.getString("rom"), rs.getString("sim"), rs.getString("battery"),
						rs.getString("charge"), product);
				return productDetail;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void update(ProductDetail productDetail) {
		String sql = "UPDATE product_detail SET monitor=?,os=?,rearCamera=?,frontCamera=?,chip=?,ram=?,rom=?,sim=?,battery=?,charge=? WHERE productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, productDetail.getMonitor());
			pst.setString(2, productDetail.getOs());
			pst.setString(3, productDetail.getRearCamera());
			pst.setString(4, productDetail.getFrontCamera());
			pst.setString(5, productDetail.getChip());
			pst.setString(6, productDetail.getRam());
			pst.setString(7, productDetail.getRom());
			pst.setString(8, productDetail.getSim());
			pst.setString(9, productDetail.getBattery());
			pst.setString(10, productDetail.getCharge());
			pst.setInt(11, productDetail.getProduct().getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(ProductDetail productDetail) {
		String sql = "INSERT INTO product_detail VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, productDetail.getMonitor());
			pst.setString(2, productDetail.getOs());
			pst.setString(3, productDetail.getRearCamera());
			pst.setString(4, productDetail.getFrontCamera());
			pst.setString(5, productDetail.getChip());
			pst.setString(6, productDetail.getRam());
			pst.setString(7, productDetail.getRom());
			pst.setString(8, productDetail.getSim());
			pst.setString(9, productDetail.getBattery());
			pst.setString(10, productDetail.getCharge());
			pst.setInt(11, productDetail.getProduct().getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
