package indi.cc.vendingmachine.model;

import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class PurchaseRecordsModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//列名
	private Vector<Vector<String>> rowData = null;	//行数据
	
	
	 public PurchaseRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<PurchaseRecords> records = helper.getAllPurchaseRecords();	//得到所有的取现补充记录
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("顾客编号");
			columnNames.add("饮料名称");
			columnNames.add("价格");
			columnNames.add("支付金额");
			columnNames.add("找回金额");
			columnNames.add("购买时间");
			
			if(records!=null){
				for(PurchaseRecords record : records){
					Vector<String> hang = new Vector<String>();
					hang.add(String.valueOf(record.getCustomerId()));
					hang.add(record.getDrinkName());
					hang.add(record.getPrice()+"元");
					hang.add(record.getPayment()+"元");
					hang.add(record.getRepayment()+"元");
					hang.add(record.getDate());
					rowData.add(hang);
					
				}
			}
			
			
			
			if(getRowCount()!=0){
				JOptionPane.showMessageDialog(jd, "一共有"+getRowCount()+"条记录！");
				return ;
			}else{
				JOptionPane.showMessageDialog(jd, "没有任何记录！");
				return ;
			}
		}
	
	
	
	//得到共有多少行
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return this.rowData.size();
			}
			//得到共有多少列
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return this.columnNames.size();
			}
			//得到某行某列的数据
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
			}
			
			//重写方法 getColumnName
			@Override  
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return (String)this.columnNames.get(column);
			}


}
