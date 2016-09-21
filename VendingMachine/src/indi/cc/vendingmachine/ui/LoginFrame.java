package indi.cc.vendingmachine.ui;

import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends javax.swing.JFrame {

	   private JButton jButton1;
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JPasswordField jPasswordField1;
	    private JTextField jTextField1;
	    private JFrame jf;
	    
	    public LoginFrame() {
    	this.jf = this;
        initComponents();
        this.setSize(320, 250);
        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }


    private void initComponents() {

        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();

        
        setTitle("管理员登陆");
        getContentPane().setLayout(null);

        jLabel1.setText("密码：");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 100, 50, 24);

      
        getContentPane().add(jTextField1);
        jTextField1.setBounds(110, 50, 114, 21);

        jLabel2.setText("用户名：");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 50, 60, 24);

       
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(110, 100, 113, 21);

        jButton1.setText("登陆");
       //注册事件
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String username = jTextField1.getText().trim();
				String password = String.valueOf(jPasswordField1.getPassword());
				if(username.equals("")){
					JOptionPane.showMessageDialog(jf, "用户名不能为空!!");
					return ;
				}else if(password.equals("")){
					JOptionPane.showMessageDialog(jf, "密码不能为空!!");
					return ;
				}else{
					Administrator admin = new Administrator(username,password);
					AdminManageHelper manageHelper = new AdminManageHelper();
					if(manageHelper.Login(admin)){
						JOptionPane.showMessageDialog(jf, "登陆成功!!");
						AdminChoose adminChoose = new AdminChoose(admin);
						jf.dispose();
						return ;
					}else{
						JOptionPane.showMessageDialog(jf, "用户名或密码错误!!");
						jTextField1.setText("");
						jPasswordField1.setText("");
						jTextField1.requestFocus();//获取焦点
						return ;
					}
				}
				
			}
		});
        
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 150, 60, 23);
        //注册窗口事件
        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				MainFrame frame = new MainFrame();
				
				
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        pack();
    }

    
    

   
}

