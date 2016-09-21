package indi.cc.vendingmachine.model;

import indi.cc.vendingmachine.bean.AddRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;




import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
//零钱补充记录数据模型
public class AddRecordModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//列名
	private Vector<Vector<String>> rowData = null;	//行数据
	
	 public AddRecordModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<AddRecords> records = helper.getAllAddRecords();	//得到所有的零钱补充记录
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("编号");
			columnNames.add("操作管理员");
			columnNames.add("补充前的金额");
			columnNames.add("补充金额");
			columnNames.add("补充后的金额");
			columnNames.add("补充的时间");
			
			if(records!=null){
				for(AddRecords record : records){
					Vector<String> hang = new Vector<String>();
					hang.add(String.valueOf(record.getId()));
					hang.add(record.getAdministrator());
					hang.add(record.getBeforeAdd()+"元");
					hang.add(record.getAddAmount()+"元");
					hang.add(record.getAfterAdd()+"元");
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
