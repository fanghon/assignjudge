package edu.jmi.ATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

public class selectFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectFrame frame = new selectFrame();
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
	public selectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u4F59\u989D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFrame.this.dispose();
				queryMoneyFrame query=new queryMoneyFrame();
				query.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 115, 119, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6B3E");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 195, 119, 43);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFrame.this.dispose();
				getMoneyFrame getmoneyframe=new getMoneyFrame();
				getmoneyframe.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u5B58\u6B3E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFrame.this.dispose();
				saveMoneyFrame saveMoney=new saveMoneyFrame();
				saveMoney.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(10, 283, 119, 43);
		contentPane.add(button);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u60A8\u9700\u8981\u7684\u4E1A\u52A1");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(162, 55, 151, 15);
		contentPane.add(label);
		
		JButton btnNewButton_2 = new JButton("\u8F6C\u8D26");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFrame.this.dispose();
				tranferFrame trans=new tranferFrame();
				trans.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_2.setBounds(325, 115, 107, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFrame.this.dispose();
				newPwdFrame pwd=new newPwdFrame ();
				pwd.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_3.setBounds(325, 283, 107, 43);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u663E\u793A\u4EA4\u6613\u8BB0\u5F55");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFrame.this.dispose();
				transInfoFrame transInfo=new transInfoFrame();
				transInfo.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_4.setBounds(325, 195, 107, 43);
		contentPane.add(btnNewButton_4);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component frame = null;
				int m=  JOptionPane.showConfirmDialog(frame,"确定退出", "information",JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					       if (m == JOptionPane.OK_OPTION)
					          System.exit(0);
					          else if(m==JOptionPane.CANCEL_OPTION){
					    	   selectFrame.this.dispose();
					    	   selectFrame frame1=new  selectFrame();
					    	   frame1.setVisible(true);
					       }
			}
		});
		button_1.setBounds(325, 401, 107, 36);
		contentPane.add(button_1);
		
		JButton btnNewButton_5 = new JButton("\u8FD4\u56DE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFrame.this.dispose();
				LoginFrame login=new LoginFrame();
				login.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_5.setBounds(10, 397, 119, 43);
		contentPane.add(btnNewButton_5);
	}
}
