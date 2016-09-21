package indi.cc.vendingmachine.bean;

import indi.cc.vendingmachine.dao.AdminManageHelper;

//自动售货机类
public class VendingMachine {
	private int totalAmount;	//总金额
	private int coin;	//硬币零钱

	
	 //使用静态属性保存该类的一个实例  
    private static VendingMachine instance;  
    //构造器私有化，避免该类被多次实例化  
    private VendingMachine(){  
      
    }  
    //提供静态方法返回该类实例   
    public static VendingMachine getInstance(){  
        //实例化类实例前，先检查该实例是否存在  
        if(instance == null){  
            //如果不存在，则新建一个实例  
            instance = new VendingMachine();  
        }  
        //返回该类的成员变量：该类的实例   
        return instance;      
    }  
	
	

	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}

	
}
