package model;

public class ProductSize {
	private int sizeId;
	private String sizeName;
	private Product product;

	public ProductSize() {
		super();
	}

	public ProductSize(int sizeId, String sizeName, Product product) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		this.product = product;
	}

	public ProductSize(int sizeId, String sizeName) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
