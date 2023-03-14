package model;

public class Product {
	private int productId;
	private String productName;
	private int price;
	private int originalPrice;
	private int viewCount;
	private String description;
	private int status;
	private Category category;

	public Product(int productId, String productName, int price, int originalPrice, int viewCount, String description,
			int status, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.originalPrice = originalPrice;
		this.viewCount = viewCount;
		this.description = description;
		this.status = status;
		this.category = category;

	}

	public Product(int productId, String productName, int price, int originalPrice, String description, int status,
			Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.originalPrice = originalPrice;
		this.description = description;
		this.status = status;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", originalPrice=" + originalPrice + ", viewCount=" + viewCount + ", description=" + description
				+ ", status=" + status + ", category=" + category + "]";
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
		super();
	}

}
