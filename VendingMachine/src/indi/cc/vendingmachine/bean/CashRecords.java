package indi.cc.vendingmachine.bean;



//取现记录类
public class CashRecords {
	private int id;	//编号
	private String administrator;	//操作管理员
	private int beforeCash;	//取现前的金额
	private int cash;	//取现金额
	private int afterCash;	//取现后的金额
	public int getBeforeCash() {
		return beforeCash;
	}
	public void setBeforeCash(int beforeCash) {
		this.beforeCash = beforeCash;
	}
	public int getAfterCash() {
		return afterCash;
	}
	public void setAfterCash(int afterCash) {
		this.afterCash = afterCash;
	}
	private String date;	//取现时间
	
	
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

	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	
}
