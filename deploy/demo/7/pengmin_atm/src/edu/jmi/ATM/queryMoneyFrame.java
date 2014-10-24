package edu.jmi.ATM;

import java.awt.BorderLayout;
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

public class queryMoneyFrame extends JFrame {

	private JPanel contentPane;
	ATMManager atm=ATMManager.getIInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryMoneyFrame frame = new queryMoneyFrame();
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
	public queryMoneyFrame() {
		setTitle("\u67E5\u8BE2\u4F59\u989D\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u60A8\u5F53\u524D\u7684\u4F59\u989D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(44, 56, 105, 22);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u53EF\u7528\u4F59\u989D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(69, 119, 75, 22);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryMoneyFrame.this.dispose();
				selectFrame select=new selectFrame();
				select.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(44, 212, 105, 37);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component frame = null;
				int m=  JOptionPane.showConfirmDialog(frame,  "确定退出", "information",JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					       if (m == JOptionPane.OK_OPTION)
					          System.exit(0);
					          else if(m==JOptionPane.CANCEL_OPTION){
					    	   queryMoneyFrame.this.dispose();
					    	   selectFrame frame1=new  selectFrame();
					    	   frame1.setVisible(true);
					       }
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(280, 212, 75, 37);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(95, 165, 54, 15);
		contentPane.add(label_1);
	    String money=Integer.toString(atm.queryMoney());
		JLabel lblNewLabel_1 = new JLabel(money);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(162, 56, 75, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(money);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(162, 119, 75, 22);
		contentPane.add(lblNewLabel_2);
	}
}
