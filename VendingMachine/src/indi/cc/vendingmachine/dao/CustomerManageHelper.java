package indi.cc.vendingmachine.dao;

import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;

//顾客操作数据库帮助类
public class CustomerManageHelper {
	private SqlHelper helper;
	/**
	 * 添加顾客购买记录
	 * @param record 购买记录
	 */
	public void addPurchaseRecords(PurchaseRecords record){
		helper = new SqlHelper();
		helper.addPurchaseRecords(record);
		helper.close();
	}
	
	/**
	 * 购买饮料
	 * @param drink 饮料对象
	 */
	public void buyDrink(Drink drink){
		helper = new SqlHelper();
		helper.buyDrink(drink);
		helper.close();
		
	}
	
}
