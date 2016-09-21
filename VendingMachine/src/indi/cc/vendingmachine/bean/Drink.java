package indi.cc.vendingmachine.bean;
//饮料类
public class Drink {
	private String id;	//饮料编号
	private String drinkName;	//饮料名字
	private String drinkImg;	//饮料图片
	private int price;	//饮料价格
	private int quantity;	//饮料数量
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public String getDrinkImg() {
		return drinkImg;
	}
	public void setDrinkImg(String drinkImg) {
		this.drinkImg = drinkImg;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
