package model;

public class ProductDetail {
	private String monitor;
	private String os;
	private String rearCamera;
	private String frontCamera;
	private String chip;
	private String ram;
	private String rom;
	private String sim;
	private String battery;
	private String charge;
	private Product product;

	public ProductDetail() {
		super();
	}

	public ProductDetail(String monitor, String os, String rearCamera, String frontCamera, String chip, String ram,
			String rom, String sim, String battery, String charge, Product product) {
		super();
		this.monitor = monitor;
		this.os = os;
		this.rearCamera = rearCamera;
		this.frontCamera = frontCamera;
		this.chip = chip;
		this.ram = ram;
		this.rom = rom;
		this.sim = sim;
		this.battery = battery;
		this.charge = charge;
		this.product = product;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getRearCamera() {
		return rearCamera;
	}

	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}

	public String getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
