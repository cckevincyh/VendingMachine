package indi.cc.vendingmachine.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.bean.VendingMachine;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CashManageFrame extends javax.swing.JDialog {

	private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private Administrator admin;
	    private JDialog jd;
	    	/**
			 * 
			 * @param owner 它的父窗口
			 * @param title 窗口名
			 * @param modal 指定的模式窗口，还有非模式窗口
			 */
			public CashManageFrame(JFrame owner, String title, boolean modal,Administrator admin){
		    	super(owner, title, modal);
		    	this.admin = admin;
				  initComponents();
				  WindowUtil.setFrameCenter(this);
			        this.setResizable(false);
			        this.setVisible(true);
			}
			
    private void initComponents() {
    	this.jd = this;
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

      

        jButton1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton1.setText("金额查看");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AmountQuery amountQuery = new AmountQuery(jd, "金额查看", true);
			}
		});
       

        jButton2.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton2.setText("零钱补充");
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddCoinFrame addCoinFrame = new AddCoinFrame(jd, "补充零钱", true,admin);
			}
		});

        jButton3.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton3.setText("金额取现");
       jButton3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			 int option = JOptionPane.showConfirmDialog(jd, "全部取现", "取消", JOptionPane.YES_NO_OPTION);
			 if(option==JOptionPane.YES_OPTION){
				 //全部取现
				 AdminManageHelper helper = new AdminManageHelper();
				 int totalAmount = VendingMachine.getInstance().getTotalAmount();
				// 添加取现记录
				 CashRecords record = new CashRecords();
				 record.setAdministrator(admin.getUsername());
				 record.setBeforeCash(totalAmount);
				 if(totalAmount!=0){
					 VendingMachine.getInstance().setTotalAmount(0);
					 helper.updateVendingMachine(VendingMachine.getInstance());
					 JOptionPane.showMessageDialog(jd, "您一共取出了:"+totalAmount+"元!!");	
					 record.setCash(totalAmount);
					 record.setAfterCash(0);
					 helper.addCashRecords(record);//添加取现记录

				 }else{
					 JOptionPane.showMessageDialog(jd, "暂无可取现的金额!!");
				 }
				 
			}

		}
	});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jButton2)
                .addGap(37, 37, 37)
                .addComponent(jButton3)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }

               
   
                  
}
