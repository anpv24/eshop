package model;

public class ProductImage {
	private int imageId;
	private String imagePath;
	private int isDefault;
	private Product product;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductImage() {
		super();
	}

	@Override
	public String toString() {
		return "ProductImage [imagePath=" + imagePath + "]";
	}

	public ProductImage(int imageId, String imagePath, int isDefault) {
		super();
		this.imageId = imageId;
		this.imagePath = imagePath;
		this.isDefault = isDefault;
	}

	public ProductImage(int imageId, String imagePath, int isDefault, Product product) {
		super();
		this.imageId = imageId;
		this.imagePath = imagePath;
		this.isDefault = isDefault;
		this.product = product;
	}
}
