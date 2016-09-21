package indi.cc.vendingmachine.dao;

import java.util.Vector;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.bean.AddRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.bean.VendingMachine;

//管理员操作数据库帮助类
public class AdminManageHelper {
	private SqlHelper helper;
	
	public AdminManageHelper(){
		
	}
	
	/**
	 * 得到管理员对象 
	 * @param admin 管理员
	 * @return 返回管理员对象
	 */
	public Administrator getAdmin(Administrator admin){
		helper = new SqlHelper();
		Administrator administrator = helper.getAdmin(admin);
		helper.close();
		return administrator;
	}
	
	
	
	
	/**
	 * 管理员登陆
	 * @param admin 管理员
	 * @return 返回是否登陆成功
	 */
	public boolean Login(Administrator admin){
		Administrator administrator = getAdmin(admin);
		if(admin.getPassword().equals(administrator.getPassword())){
			return true;
		}
		return false;
	}
	
	/**
	 * 添加管理员
	 * @param admin	管理员
	 * @return 返回是否添加成功
	 */
	public boolean addAdmin(Administrator admin){
		helper = new SqlHelper();
		boolean b = helper.addAdmin(admin);
		helper.close();
		return b;
	}
	
	/**
	 * 修改管理员密码
	 * @param oldAdmin 旧管理员
	 * @param newAdmin 新管理员
	 * @return 返回是否修改成功
	 */
	public boolean updatePassword(Administrator oldAdmin,Administrator newAdmin){
		helper = new SqlHelper();
		boolean b = helper.updateAdmin(oldAdmin, newAdmin);
		helper.close();
		return b;
	}
	
	
	/**
	 * 返回所有的饮料
	 * @return 所有的饮料集合
	 */
	public Vector<Drink> getAllDrink(){
		helper = new SqlHelper();
		Vector<Drink> drinks = helper.getAllDrink();
		helper.close();
		return drinks;
	}
	
	/**
	 * 添加饮料
	 * @param drink 饮料对象
	 * @return	是否添加成功
	 */
	public boolean addDrink(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.addDrink(drink);
		helper.close();
		return b;
	}
	
	/**
	 * 修改饮料信息
	 * @param oldDrink 旧饮料对象
	 * @param drink 饮料对象
	 * @return 返回是否修改成功
	 */
	public boolean updateDrink(Drink oldDrink,Drink drink){
		helper = new SqlHelper();
		boolean b = helper.updateDrink(oldDrink, drink);
		helper.close();
		return b;
	}
	
	/**
	 * 删除饮料
	 * @param drink 饮料对象
	 * @return 返回是否修改成功
	 */
	public boolean deleteDrink(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.deleteDrink(drink);
		helper.close();
		return b;
	}
	
	/**
	 * 修改饮料数量
	 * @param drink 饮料对象
	 * @return
	 */
	public boolean updateDrinkNum(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.updateDrinkNum(drink);
		helper.close();
		return b;
	}
	
	
	/**
	 * 初始化饮料机对象
	 * 
	 */
	public void getVendingMachine(){
		helper = new SqlHelper();
		helper.getVendingMachine();
		helper.close();
	}
	
	
	/**
	 * 修改饮料机对象
	 * @param machine 饮料机对象
	 * @return 返回是否修改成功
	 */
	public boolean updateVendingMachine(VendingMachine machine){
		helper = new SqlHelper();
		boolean b = helper.updateVendingMachine(machine);
		helper.close();
		return b;
	}
	
	/**
	 * 获得所有的零钱补充记录
	 * @return 返回零钱补充记录集合
	 */
	public Vector<AddRecords> getAllAddRecords(){
		helper = new SqlHelper();
		Vector<AddRecords> records  = helper.getAllAddRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * 添加补充零钱记录
	 * @param record 补充零钱记录
	 */
	public void addAddRecords(AddRecords record){
		helper = new SqlHelper();
		helper.addAddRecords(record);
		helper.close();
	}
	
	
	
	/**
	 * 获得所有的取现记录
	 * @return 返回取现记录集合
	 */
	public Vector<CashRecords> getAllCashRecords(){
		helper = new SqlHelper();
		Vector<CashRecords> records  = helper.getAllCashRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * 添加取现记录
	 * @param record
	 */
	public void addCashRecords(CashRecords record){
		helper = new SqlHelper();
		helper.addCashRecords(record);
		helper.close();
		
	}
	
	/**
	 * 获得所有的顾客购买记录
	 * @return 返回顾客购买记录集合
	 */
	public Vector<PurchaseRecords> getAllPurchaseRecords(){
		helper = new SqlHelper();
		Vector<PurchaseRecords> records  = helper.getAllPurchaseRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * 得到所有添加饮料的记录
	 * @return 返回所有添加饮料记录
	 */
	public Vector<AddDrinkRecords> getAllAddDrinkRecords(){
		helper = new SqlHelper();
		Vector<AddDrinkRecords> records = helper.getAllAddDrinkRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * 添加饮料补充记录
	 * @param record 饮料补充记录
	 */
	public void addAddDrinkRecords(AddDrinkRecords record){
		helper = new SqlHelper();
		helper.addAddDrinkRecords(record);
		helper.close();
		
	}
}
