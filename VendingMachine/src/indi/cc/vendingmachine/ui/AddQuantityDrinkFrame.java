package indi.cc.vendingmachine.ui;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class AddQuantityDrinkFrame extends javax.swing.JDialog {

	 private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JTextField jTextField1;
	     private JDialog jd;
	     private Drink drink;
	     private Administrator admin;
	    /**
		 * 
		 * @param owner 它的父窗口
		 * @param title 窗口名
		 * @param modal 指定的模式窗口，还有非模式窗口
		 */
		public AddQuantityDrinkFrame(JDialog owner, String title, boolean modal,Drink drink,Administrator admin){
	    	super(owner, title, modal);
	    	this.admin = admin;
	    	this.drink = drink;
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
       
        jLabel1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jLabel1.setText("请补充饮料:");

        jButton1.setText("添加");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = jTextField1.getText().trim();	//得到输入的值
				if(s.equals("")||Integer.parseInt(s)==0){
					JOptionPane.showMessageDialog(jd, "请补充饮料!!");
				}else{
					AdminManageHelper helper = new AdminManageHelper();
					//添加饮料补充记录
					AddDrinkRecords record = new AddDrinkRecords();
					record.setAdministrator(admin.getUsername());
					record.setDrinkName(drink.getDrinkName());
					record.setBefroeNum(drink.getQuantity());//设置补充前的数量
					drink.setQuantity(Integer.parseInt(s)+drink.getQuantity());//设置数量
					record.setAddNum(Integer.parseInt(s));//设置补充的数量
					record.setNowNum(drink.getQuantity());//设置补充后的数量
					helper.updateDrinkNum(drink);	//补充饮料数量
					helper.addAddDrinkRecords(record);	//添加补充饮料的记录
					JOptionPane.showMessageDialog(jd, "您一共补充了饮料:"+Integer.parseInt(s)+"瓶!!");
					
					jd.dispose();
				}
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }                
   
}
