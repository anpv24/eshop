package model;

public class Category {
	private int categoryId;
	private String categoryName;
	private int status;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Category() {
		super();
	}

	public Category(int categoryId, String categoryName, int status) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", status=" + status + "]";
	}
}
