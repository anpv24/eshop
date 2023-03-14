package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Category;
import model.Product;

public class ProductDAO extends DBConnect {
	CategoryDAO categoryDAO = new CategoryDAO();

	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT productId,productName,price,originalPrice,viewCount,"
				+ "description,product.status,category.categoryId AS categoryId,categoryName"
				+ " FROM product INNER JOIN category" + " ON product.categoryId = category.categoryId";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public Product getByIdForAdd(int productId) {
		String sql = "SELECT productId,productName,price,originalPrice,description,status,categoryId FROM product WHERE productId=?";
		try {
			Category category = new Category();

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getString("description"), rs.getInt("status"), category);
				return product;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> seachByName(String productName) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE productName LIKE ? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	public List<Product> seachByPrice(int priceL, int priceU) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE price between ? and ? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, priceL);
			ps.setInt(2, priceU);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> searchByPriceUp(int price) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE price >=? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, price);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> searchByPriceHigh() {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product order by price DESC ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> searchByPriceLow() {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product order by price ASC ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> searchProductByPriceLow(String productName) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product having productName LIKE ? order by price ASC";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	public List<Product> searchProductByPriceHigh(String productName) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product having productName LIKE ? order by price DESC";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	public List<Product> searchByNameAndPrice(String productName, int priceL, int priceH) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product having productName LIKE ? and price between ? and ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ps.setInt(2, priceL);
			ps.setInt(3, priceH);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	public List<Product> searchByNameAndPriceUp(String productName, int price) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product having productName LIKE ? and price >=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ps.setInt(2, price);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> searchByNameS3H(String productName, int priceL, int priceH) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product having productName LIKE ? and price between ? and ? order by price desc";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ps.setInt(2, priceL);
			ps.setInt(3, priceH);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> searchByNameS3L(String productName, int priceL, int priceH) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product having productName LIKE ? and price between ? and ? order by price ASC";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ps.setInt(2, priceL);
			ps.setInt(3, priceH);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> searchByNameS3UpL(String productName, int price) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product having productName LIKE ? and price >= ? order by price ASC";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ps.setInt(2, price);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> searchByNameS3UpH(String productName, int price) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product having productName LIKE ? and price >= ? order by price DESC";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ps.setInt(2, price);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
//	public int count() {
//		String sql = "select count(*) from product";
//		try {
//			PreparedStatement pst = conn.prepareStatement(sql);
//			ResultSet rs = pst.executeQuery();
//			while (rs.next()) {
//				return rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}

	public Product getById(int id) {
		String sql = "SELECT * FROM product WHERE productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Category category = categoryDAO.getById(rs.getInt("categoryId"));
				Product product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getInt("price"),
						rs.getInt("originalPrice"), rs.getInt("viewCount"), rs.getString("description"),
						rs.getInt("status"), category);
				return product;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		List<Cart> book = new ArrayList<Cart>();
		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					System.out.println("product name: " + item.getProductName());
					String query = "select * from product where productId=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setInt(1, item.getProductId());
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						Category category = categoryDAO.getById(rs.getInt("categoryId"));
						Cart row = new Cart();
						row.setProductId(rs.getInt("productId"));
						row.setProductName(rs.getString("productName"));
						System.out.println("name: " + rs.getString("productName"));
						row.setCategory(category);
						row.setPrice(rs.getInt("price"));
						row.setQuantity(item.getQuantity());
						book.add(row);
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return book;
	}

	public int getTotalCartPrice(ArrayList<Cart> cartList) {
		int sum = 0;
		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					String query = "select price from product where productId=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setInt(1, item.getProductId());
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						sum += rs.getInt("price") * item.getQuantity();
					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return sum;
	}

	public void insert(Product product) {
		String sql = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, product.getProductId());
			pst.setString(2, product.getProductName());
			pst.setInt(3, product.getPrice());
			pst.setInt(4, product.getOriginalPrice());
			pst.setInt(5, product.getViewCount());
			pst.setString(6, product.getDescription());
			pst.setInt(7, product.getStatus());
			pst.setInt(8, product.getCategory().getCategoryId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Product product) {
		String sql = "UPDATE product SET productName=?,price=?,originalPrice=?,description=?,status=?,categoryId=? WHERE productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getOriginalPrice());
			pst.setString(4, product.getDescription());
			pst.setInt(5, product.getStatus());
			pst.setInt(6, product.getCategory().getCategoryId());
			pst.setInt(7, product.getProductId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int productId) {
		String sql = "DELETE FROM product WHERE productId=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, productId);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
