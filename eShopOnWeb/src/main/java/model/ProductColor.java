package model;

public class ProductColor {
	private int colorId;
	private String colorName;
	private Product product;

	public ProductColor(int colorId, String colorName, Product product) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
		this.product = product;
	}

	public ProductColor() {
		super();
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductColor(int colorId, String colorName) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
	}

}
