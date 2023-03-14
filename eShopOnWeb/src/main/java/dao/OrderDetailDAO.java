package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Order;
import model.OrderDetail;
import model.Product;

public class OrderDetailDAO extends DBConnect {
	public OrderDetail getAll() {
		String sql = "select * from orderdetail";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ProductDAO dao = new ProductDAO();
				Product product = dao.getById(rs.getInt("productId"));
				OrderDAO dao2 = new OrderDAO();
				Order order = dao2.getById(rs.getInt("orderId"));
				OrderDetail orderDetail = new OrderDetail(rs.getInt("orderDetailId"), product, order,
						rs.getInt("quantity"));
				return orderDetail;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public OrderDetail getByOrderId(int orderId) {
		String sql = "select * from orders inner join orderdetail "
				+ " on orders.orderId = orderdetail.orderId where orderId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, orderId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				ProductDAO dao = new ProductDAO();
				Product product = dao.getById(rs.getInt("productId"));
				OrderDAO dao2 = new OrderDAO();
				Order order = dao2.getById(rs.getInt("orderId"));
				OrderDetail orderDetail = new OrderDetail(rs.getInt("orderDetailId"), product, order,
						rs.getInt("quantity"));
				return orderDetail;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(OrderDetail detail) {
		String sql = "INSERT INTO orderDetail VALUES(?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, detail.getOrderDetailId());
			pst.setInt(2, detail.getProduct().getProductId());
			pst.setInt(3, detail.getOrder().getOrderId());
			pst.setInt(4, detail.getQuantity());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		// boolean result = false;
		try {
			String query = "delete from orderDetail where orderDetailId=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeUpdate();
			// result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		// return result;
	}
}
