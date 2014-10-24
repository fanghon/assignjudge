package edu.jmi.ATM;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tranferFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
    ATMManager atm = ATMManager.getIInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tranferFrame frame = new tranferFrame();
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
	public tranferFrame() {
		setTitle("\u8F6C\u8D26\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8F6C\u8D26\u5E10\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(23, 48, 189, 34);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 14));
		textField.setBounds(173, 53, 145, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8F6C\u5E10\u91D1\u989D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 124, 139, 26);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_1.setBounds(173, 127, 145, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tranferFrame.this.dispose();
				selectFrame select=new selectFrame();
				select.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(42, 262, 120, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component frame = null;
				int m=  JOptionPane.showConfirmDialog(frame,  "确定退出", "information",JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					       if (m == JOptionPane.OK_OPTION)
					          System.exit(0);
					          else if(m==JOptionPane.CANCEL_OPTION){
					    	   tranferFrame.this.dispose();
					    	   selectFrame frame1=new  selectFrame();
					    	   frame1.setVisible(true);
					       }
			
			}
		});
		btnNewButton_1.setBounds(315, 262, 95, 34);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String desname=textField.getText();
				if(ValidInput(desname))
				{
				int transmoney=Integer.valueOf(textField_1.getText());			    
				  //1 成功；-1表示不是100的倍数；-2，对方账户不存在，-3 余额不足，-4 转账失败			
					int result = atm.transferMoney(desname,transmoney);
						if(result==1){
							JOptionPane.showMessageDialog(tranferFrame.this,"转账成功");
						}
						if(result==-1){
							JOptionPane.showMessageDialog(tranferFrame.this,"转账金额必须为100的倍数！");
						}
						if (result==-2){
								JOptionPane.showMessageDialog(tranferFrame.this,"对方账号不存在！请重新输入");
							}
						if (result==-3){
							JOptionPane.showMessageDialog(tranferFrame.this,"您的余额不足！");
						}
						if (result==-4){
							JOptionPane.showMessageDialog(tranferFrame.this,"转账失败");
						}
										
			
			}
				else{
					JOptionPane.showMessageDialog(tranferFrame.this,"输入不能为空");
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(173, 210, 95, 34);
		contentPane.add(button);
	}
	boolean ValidInput(String input){
		boolean res=false;
		if(input!=null&&!input.trim().equals(""))
					return true;
	    return res;				
	}
}
