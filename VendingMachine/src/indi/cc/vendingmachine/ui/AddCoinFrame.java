package indi.cc.vendingmachine.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import indi.cc.vendingmachine.bean.AddRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.VendingMachine;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
//添加零钱界面

public class AddCoinFrame extends javax.swing.JDialog {
    
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField jTextField1;
	private JDialog jd;
	private Administrator admin;
	/**
	 * 
	 * @param owner 它的父窗口
	 * @param title 窗口名
	 * @param modal 指定的模式窗口，还有非模式窗口
	 */
	public AddCoinFrame(JDialog owner, String title, boolean modal,Administrator admin){
		super(owner, title, modal);
		this.admin = admin;
		  initComponents();
		  WindowUtil.setFrameCenter(this);
	        this.setResizable(false);
	        this.setVisible(true);
	}
	
    private void initComponents() {
    	this.jd = this;
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField1.requestFocus();//获取焦点
       

        jLabel1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jLabel1.setText("请添加零钱:");
        jTextField1.addKeyListener(new KeyAdapter(){  
        	//限制只能输入数字
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        }); 
       

        jButton1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton1.setText("添加");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputValue = jTextField1.getText().trim();
				if(inputValue.equals("")||Integer.parseInt(inputValue)==0){
					JOptionPane.showMessageDialog(jd, "请放入零钱!!");
					jTextField1.setText("");
				}else{
					AdminManageHelper helper = new AdminManageHelper();
					//记录补充零钱的记录
					AddRecords record = new AddRecords();
					record.setAdministrator(admin.getUsername());//操作管理员
					record.setBeforeAdd(VendingMachine.getInstance().getCoin());//获取补充前的零钱金额
					VendingMachine.getInstance().setCoin(Integer.parseInt(inputValue)+VendingMachine.getInstance().getCoin());
					helper.updateVendingMachine(VendingMachine.getInstance());
					JOptionPane.showMessageDialog(jd, "您已补充了零钱:"+inputValue+"元!!");	
					record.setAddAmount(Integer.parseInt(inputValue));//设置添加的金额
					record.setAfterAdd(VendingMachine.getInstance().getCoin());
					helper.addAddRecords(record);	///添加纪录
					
					jd.dispose();
				}
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }                                   


                     
}
