package edu.jmi.ATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class saveMoneyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ATMManager atm=ATMManager.getIInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saveMoneyFrame frame = new saveMoneyFrame();
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
	public saveMoneyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5B58\u6B3E\u91D1\u989D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(36, 63, 137, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 14));
		textField.setBounds(171, 63, 137, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input= textField.getText();
				if(ValidInput(input))
				{
				int money =  Integer.valueOf(input);
				
				//返回：1 成功，-1表示不是100的倍数，返回-2，表示超过10000，-4 存钱失败
		        int result=atm.saveMoney(money);
				if(result==1){
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"存款成功");
				}
				if(result==-1){
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"存款金额必须为100的倍数");
				}
				if(result==-2){
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"存款金额不能超过10000");
				}
				if(result==-4){
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"存款失败");
				}
				}
				else{
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"输入不能为空");
				}
			}			
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(38, 212, 95, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveMoneyFrame.this.dispose();
				selectFrame select=new selectFrame();
				select.setVisible(true);
			}
		});
		button_1.setBounds(254, 214, 106, 30);
		contentPane.add(button_1);
	}
	boolean ValidInput(String input){
		boolean res=false;
		if(input!=null&&!input.trim().equals(""))
					return true;
	    return res;				
	}
}
