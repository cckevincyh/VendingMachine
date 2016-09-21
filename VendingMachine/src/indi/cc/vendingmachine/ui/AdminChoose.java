package indi.cc.vendingmachine.ui;

import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class AdminChoose extends javax.swing.JFrame {
    
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private JFrame jf;
	private Administrator admin;
    public AdminChoose(Administrator admin) {
    	this.admin = admin;
        initComponents();
        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }

                       
    private void initComponents() {
    	this.jf = this;
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton3 = new JButton();

        setTitle("管理员："+admin.getUsername());
        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton1.setText("添加新管理员");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddAdminFrame addAdminFrame = new AddAdminFrame(jf, "添加新管理员", true);
			}
		});

        jButton2.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton2.setText("修改密码");
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdatePasswordFrame frame = new UpdatePasswordFrame(jf, "修改密码", true,admin);
			}
		});

        jButton4.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton4.setText("金额管理");
        jButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CashManageFrame frame = new CashManageFrame(jf, "金额管理", true,admin);
			}
		});
        
        
        jButton5.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton5.setText("记录查看");
        jButton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				RecordsManageFrame frame = new RecordsManageFrame(jf, "记录查看", true);
			}
		});
       

        jButton6.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton6.setText("退出系统");
        jButton6.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			jf.dispose();
    			MainFrame frame = new MainFrame();
    			
    		}
    	});
      
        jButton3.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton3.setText("饮料管理");
        jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DrinkManageFrame drinkManage = new DrinkManageFrame(jf, "饮料管理", true,admin);
			}
		});
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addGap(28, 28, 28)
                .addComponent(jButton6)
                .addGap(29, 29, 29))
        );

        pack();
        
        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				jf.dispose();
				MainFrame frame = new MainFrame();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    }                    

   
       
    

   
                
}
