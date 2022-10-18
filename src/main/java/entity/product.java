package entity;

public class product {

	
	private int idproduct;
	private String nameproduct = "";
	private int price;
	private String describe = "";
	private String nameimgOrVideo = "";
	private int id_seller;

	public product() {

	}

	public product(int idproduct,String nameproduct, int price, String describe, int id_seller, String nameimgOrVideo) {
		this.idproduct = idproduct;
		this.nameproduct = nameproduct;
		this.price = price;
		this.describe = describe;
		this.id_seller = id_seller;
		this.nameimgOrVideo = nameimgOrVideo;

	}

	public String getNameproduct() {
		return nameproduct;
	}

	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getId_seller() {
		return id_seller;
	}

	public void setId_seller(int id_seller) {
		this.id_seller = id_seller;
	}

	public String getNameimgOrVideo() {
		return nameimgOrVideo;
	}

	public void setNameimgOrVideo(String nameimgOrVideo) {
		this.nameimgOrVideo = nameimgOrVideo;
	}

	
	
	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	@Override
	public String toString() {
		return "product [nameproduct=" + nameproduct + ", price=" + price + ", describe=" + describe + "]";
	}

}
