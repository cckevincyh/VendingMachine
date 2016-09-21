package indi.cc.vendingmachine.model;


import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

//取现记录数据模型
public class CashRecordsModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//列名
	private Vector<Vector<String>> rowData = null;	//行数据
	
	
	 public CashRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<CashRecords> records = helper.getAllCashRecords();	//得到所有的取现补充记录
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("编号");
			columnNames.add("操作管理员");
			columnNames.add("取现前的金额");
			columnNames.add("取现金额");
			columnNames.add("取现后的金额");
			columnNames.add("取现的时间");
			
			if(records!=null){
				for(CashRecords record : records){
					Vector<String> hang = new Vector<String>();
					hang.add(String.valueOf(record.getId()));
					hang.add(record.getAdministrator());
					hang.add(record.getBeforeCash()+"元");
					hang.add(record.getCash()+"元");
					hang.add(record.getAfterCash()+"元");
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
