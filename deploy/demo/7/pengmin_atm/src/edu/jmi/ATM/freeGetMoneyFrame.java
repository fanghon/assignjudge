package edu.jmi.ATM;

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

public class freeGetMoneyFrame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	freeGetMoneyFrame freeGet;
	ATMManager atm=ATMManager.getIInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					freeGetMoneyFrame frame = new freeGetMoneyFrame();
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
	public freeGetMoneyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u53D6\u6B3E\u7684\u91D1\u989D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(33, 70, 154, 22);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(197, 71, 154, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input= textField.getText();
				if(ValidInput(input))
				{
				int money =  Integer.valueOf(input);			
				int result=atm.getMoney(money);
				//1 成功；-1表示不是100的倍数;-2:表示超过5000；-3 :表示余额不够 ;-4 取钱失败（数据更新失败）
				if(result==1){
					JOptionPane.showMessageDialog(freeGetMoneyFrame.this,"取款成功");
				}
				if(result==-1){
					JOptionPane.showMessageDialog(freeGetMoneyFrame.this,"取款金额必须为100的倍数");	
				}
					if(result==-2){
						JOptionPane.showMessageDialog(freeGetMoneyFrame.this,"取款金额不能超过5000");
					}
					if(result==-3){
							JOptionPane.showMessageDialog(freeGetMoneyFrame.this,"您的余额不够");
					}
					if(result==-4){
							JOptionPane.showMessageDialog(freeGetMoneyFrame.this,"取款失败");
					}
				}
				else{
					JOptionPane.showMessageDialog(freeGetMoneyFrame.this,"输入不能为空");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(47, 205, 95, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   freeGetMoneyFrame.this.dispose();
			   selectFrame select=new selectFrame();
			   select.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(251, 205, 121, 25);
		contentPane.add(btnNewButton_1);
	}
	boolean ValidInput(String input){
		boolean res=false;
		if(input!=null&&!input.trim().equals(""))
					return true;
	    return res;				
	}
}
