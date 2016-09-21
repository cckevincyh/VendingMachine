package indi.cc.vendingmachine.bean;


//补充零钱记录
public class AddRecords {
	private int id;	//编号
	private String administrator;	//操作管理员
	private int  beforeAdd;	//补充前的金额
	private int addAmount;	//补充零钱金额
	private int afterAdd;	//补充后的金额
	public int getBeforeAdd() {
		return beforeAdd;
	}
	public void setBeforeAdd(int beforeAdd) {
		this.beforeAdd = beforeAdd;
	}
	public int getAfterAdd() {
		return afterAdd;
	}
	public void setAfterAdd(int afterAdd) {
		this.afterAdd = afterAdd;
	}
	private String date;	//补充时间
	
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
	
	public int getAddAmount() {
		return addAmount;
	}
	public void setAddAmount(int addAmount) {
		this.addAmount = addAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
