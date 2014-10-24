package edu.jmi.ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class newPwdFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
    ATMManager atm=ATMManager.getIInstance();
    private JPasswordField passwordField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newPwdFrame frame = new newPwdFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newPwdFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 67, 126, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(67, 108, 154, 31);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 72, 121, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(210, 113, 121, 21);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPwdFrame.this.dispose();
				selectFrame select=new selectFrame();
				select.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
		btnNewButton.setBounds(33, 225, 126, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 13));
		btnNewButton_1.setBounds(323, 227, 95, 28);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd0=new String(passwordField_2.getPassword());
				String pwd=new String(passwordField.getPassword());
				String pwd1=new String(passwordField_1.getPassword());
				if(Isempty(pwd0,pwd,pwd1)){
					if(Isformat(pwd,pwd1)){
						if(Issame0(pwd0,pwd)){
						if(Issame(pwd,pwd1))
						{if(isexsits(pwd0))
							{
								int res=atm.changePwd(pwd);
								 if(res==0)
									{//更改失败提示信息
									 JOptionPane.showMessageDialog(newPwdFrame.this,"密码修改失败！");
									}
									else if(res==1)
									{//更改成功提示信息

										JOptionPane.showMessageDialog(newPwdFrame.this,"密码更改成功！");
									}
									
							}
						else{
							JOptionPane.showMessageDialog(newPwdFrame.this,"原密码错！");
						}
						}
						else{
								JOptionPane.showMessageDialog(newPwdFrame.this,"新密码与确认密码应一致！");
							}		
					}
					else{
						JOptionPane.showMessageDialog(newPwdFrame.this,"新旧密码不能相同！");
					}
					}else
						{
							JOptionPane.showMessageDialog(newPwdFrame.this,"密码长度应为6位数字！");
						}
					}
				else{
						JOptionPane.showMessageDialog(newPwdFrame.this,"密码不能为空");
					}
				
				
			 }
				});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(194, 176, 95, 31);
		contentPane.add(button);	
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u539F\u59CB\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(53, 36, 126, 15);
		contentPane.add(lblNewLabel_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(210, 33, 121, 21);
		contentPane.add(passwordField_2);
	}
    //判断两次输入的密码是否为空
	boolean Isempty(String pwd0,String pwd,String pwd1){
		boolean res=false;
		if(pwd0!=null&&!pwd.trim().equals("")&&pwd!=null&&!pwd.trim().equals("")&&pwd1!=null&&!pwd1.trim().equals(""))
				return true;	
		return res;
	}
	//判断两次输入的密码是6为数字
	boolean Isformat(String pwd,String pwd0){
		boolean res=false;
		String patternStr="[0-9a-zA-Z]{6}";
		if(pwd.matches(patternStr)&&pwd0.matches(patternStr))
			return true;
		return res;
	}
	//判断确认密码是否等于新密码
	boolean Issame(String pwd,String pwd1){//判断确认密码是否与新密码一致
		boolean res=false;
		if(pwd1.equals(pwd))
			return true;
		return res;
	}
	boolean Issame0(String pwd,String pwd0){//判断新密码与原始密码是否一致
		boolean res=false;
		if(!pwd.equals(pwd0))
			return true;
		return res;
	}
	 public boolean isexsits(String pwd0)  {
	        boolean res = false;
	        try {
	             JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
			     Connection conn=jdbc.getConnection();   
			     String sql="select * from atm where password ='" + pwd0 + "'";
	                PreparedStatement pst=conn.prepareStatement(sql);
	                ResultSet rs= pst.executeQuery();
	                if (rs.next()) {
	                    res = true;
	                }
	                jdbc.free(rs, pst, conn);
	            } catch (SQLException ex) {
	                System.out.println("操作失败" + ex.getMessage());
	          }
    return res;
}
}
	

