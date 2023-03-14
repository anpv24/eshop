package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.Product;
import model.User;

public class OrderDAO extends DBConnect {
	public List<Order> getAll() {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from orders";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				UserDAO dao = new UserDAO();
				User user = dao.getById(rs.getInt("userId"));
				Order order = new Order(rs.getInt("orderId"), rs.getInt("totalMoney"), rs.getString("payment"),
						rs.getDate("bookingDate"), rs.getDate("deliveryDate"), rs.getString("shippingWay"),
						rs.getInt("state"), rs.getString("color"), rs.getString("size"), rs.getString("note"),
						rs.getInt("transportFee"), user);
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Order getById(int orderId) {
		String sql = "SELECT * FROM orders WHERE orderId=?";
		try {

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, orderId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				UserDAO dao = new UserDAO();
				User user = dao.getById(rs.getInt("userId"));
				Order order = new Order(rs.getInt("orderId"), rs.getInt("totalMoney"), rs.getString("payment"),
						rs.getDate("bookingDate"), rs.getDate("deliveryDate"), rs.getString("shippingWay"),
						rs.getInt("state"), rs.getString("color"), rs.getString("size"), rs.getString("note"),
						rs.getInt("transportFee"), user);
				return order;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Order order) {
		String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getUser().getUserId());
			pst.setInt(3, order.getTotalMoney());
			pst.setString(4, order.getPayment());
			pst.setDate(5, order.getBookingDate());
			pst.setDate(6, order.getDeliveryDate());
			pst.setString(7, order.getShippingWay());
			pst.setInt(8, order.getState());
			pst.setString(9, order.getColor());
			pst.setString(10, order.getSize());
			pst.setString(11, order.getNote());
			pst.setInt(12, order.getTransportFee());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Order> userOrders(int id) {
		List<Order> list = new ArrayList<>();
		try {
			String query = "select * from orders where userId=? order by orders.orderId desc";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				ProductDAO productDao = new ProductDAO();
				UserDAO userDAO = new UserDAO();
				int pId = rs.getInt("productId");
				Product product = productDao.getById(pId);
				User user = userDAO.getById(id);
				order.setOrderId(rs.getInt("orderId"));
				order.setUser(user);
				order.setTotalMoney(rs.getInt("totalMoney"));
				order.setPayment(rs.getString("payment"));
				order.setBookingDate(rs.getDate("bookingDate"));
				order.setDeliveryDate(rs.getDate("deliveryDate"));
				order.setShippingWay(rs.getString("shippingWay"));
				order.setState(rs.getInt("state"));
				order.setNote(rs.getString("note"));
				order.setTransportFee(rs.getInt("transportFee"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;
	}

	public void update(Order order) {
		String sql = "UPDATE orders SET userId=?,totalMoney=?,payment=?,bookingDate=?,deliveryDate=?, shippingWay=?,"
				+ "state=?, color=?, size=?, note=?, transportFee=? WHERE orderId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, order.getUser().getUserId());
			pst.setInt(2, order.getTotalMoney());
			pst.setString(3, order.getPayment());
			pst.setDate(4, order.getBookingDate());
			pst.setDate(5, order.getDeliveryDate());
			pst.setString(6, order.getShippingWay());
			pst.setInt(7, order.getState());
			pst.setString(8, order.getColor());
			pst.setString(9, order.getSize());
			pst.setString(10, order.getNote());
			pst.setInt(11, order.getTransportFee());
			pst.setInt(12, order.getOrderId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		// boolean result = false;
		try {
			String query = "delete from orders where orderId=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.execute();
			// result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		// return result;
	}
}
