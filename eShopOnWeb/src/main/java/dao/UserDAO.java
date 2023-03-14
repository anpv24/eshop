package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends DBConnect {
	public User login(String username, String password) {
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getInt("isAdmin"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT userId,username,fullname,avatar,email,phone FROM users";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("avatar"), rs.getString("phone"), rs.getString("email"), rs.getString("address"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT userId,username,password,fullname,email,phone,address FROM users WHERE isAdmin=0";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getString("phone"), rs.getString("email"),
						rs.getString("address"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int count() {
		String sql = "select count(*) from users";
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

	public int countForSearch(String username) {
		String sql = "select count(*) from users WHERE username like ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + username + "%");
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

	public List<User> search(String username, int index) {
		String sql = "select * from (select *, ROW_NUMBER() over ( order by userId asc ) as r from users "
				+ "where username like ?) as x where r between ?*15-14 and ?*15";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + username + "%");
			pst.setInt(2, index);
			pst.setInt(3, index);
			ResultSet rs = pst.executeQuery();
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getString("phone"), rs.getString("email"),
						rs.getString("address"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getById(int id) {
		String sql = "SELECT * FROM users WHERE userId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), null, rs.getString("phone"), rs.getString("email"),
						rs.getString("address"), rs.getInt("isAdmin"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getByname(String username) {
		String sql = "SELECT * FROM users WHERE username=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username.toLowerCase());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getString("avatar"), rs.getString("phone"), rs.getString("email"),
						rs.getString("address"), 0);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(User user) {
		String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getFullname());
			pst.setString(5, user.getAvatar());
			pst.setString(6, user.getPhone());
			pst.setString(7, user.getEmail());
			pst.setString(8, user.getAddress());
			pst.setInt(9, user.getIsAdmin());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(User user) {
		String sql = "UPDATE users SET  username=?,password=?,fullname=?,email=?,phone=?,address=? WHERE userId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPhone());
			pst.setString(6, user.getAddress());
			pst.setInt(7, user.getUserId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int userId) {
		String sql = "DELETE FROM users WHERE userId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
