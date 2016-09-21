package indi.cc.vendingmachine.bean;
//补充饮料数量的记录类
public class AddDrinkRecords {
	private int id;	//编号
	private String administrator;	//操作管理员
	private String drinkName;	//饮料名称
	private String date;	//添加时间
	private int befroeNum;	//添加前的数量
	private int addNum;	//添加的数量
	private int nowNum;	//现在的数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdministrator() {
		return administrator;
	}
	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBefroeNum() {
		return befroeNum;
	}
	public void setBefroeNum(int befroeNum) {
		this.befroeNum = befroeNum;
	}
	public int getAddNum() {
		return addNum;
	}
	public void setAddNum(int addNum) {
		this.addNum = addNum;
	}
	public int getNowNum() {
		return nowNum;
	}
	public void setNowNum(int nowNum) {
		this.nowNum = nowNum;
	}
	
	
}
