package edu.jmi.ATM;

import java.awt.Component;
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

public class getMoneyFrame extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
    ATMManager atm=ATMManager.getIInstance();
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getMoneyFrame frame = new getMoneyFrame();
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
	public getMoneyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u53D6\u6B3E\u91D1\u989D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(165, 31, 143, 18);
		contentPane.add(lblNewLabel);
		
		button = new JButton("100");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money=Integer.valueOf(button.getText());
				int result=atm.getMoney(money);
				if(result==1){
					JOptionPane.showMessageDialog(getMoneyFrame.this,"取款成功");
				}
				if(result==-3){
					JOptionPane.showMessageDialog(getMoneyFrame.this,"您的余额不足");
				}
				if (result==-4){
						JOptionPane.showMessageDialog(getMoneyFrame.this,"取款失败");
					}
				}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(22, 71, 95, 25);
		contentPane.add(button);
		
		 button_1 = new JButton("200");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money=Integer.valueOf(button_1.getText());
				int result=atm.getMoney(money);
				if(result==1){
					JOptionPane.showMessageDialog(getMoneyFrame.this,"取款成功");
				}
				if(result==-3){
					JOptionPane.showMessageDialog(getMoneyFrame.this,"您的余额不足");
				}
				if (result==-4){
						JOptionPane.showMessageDialog(getMoneyFrame.this,"取款失败");
					}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.setBounds(323, 71, 109, 25);
		contentPane.add(button_1);
		
		button_2 = new JButton("300");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money=Integer.valueOf(button_2.getText());
				int result=atm.getMoney(money);
				if(result==1){
					JOptionPane.showMessageDialog(getMoneyFrame.this,"取款成功");
				}
				if(result==-3){
					JOptionPane.showMessageDialog(getMoneyFrame.this,"您的余额不足");
				}
				if (result==-4){
						JOptionPane.showMessageDialog(getMoneyFrame.this,"取款失败");
					}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		button_2.setBounds(22, 139, 95, 25);
		contentPane.add(button_2);
		
	    button_3 = new JButton("400");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money=Integer.valueOf(button_3.getText());
				int result=atm.getMoney(money);
				if(result==1){
					JOptionPane.showMessageDialog(getMoneyFrame.this,"取款成功");
				}
				if(result==-3){
					JOptionPane.showMessageDialog(getMoneyFrame.this,"您的余额不足");
				}
				if (result==-4){
						JOptionPane.showMessageDialog(getMoneyFrame.this,"取款失败");
					}
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 15));
		button_3.setBounds(323, 139, 109, 25);
		contentPane.add(button_3);
		
		button_4 = new JButton("500");
		button_4.setFont(new Font("宋体", Font.PLAIN, 14));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int money=Integer.valueOf(button_4.getText());
					int result=atm.getMoney(money);
					if(result==1){
						JOptionPane.showMessageDialog(getMoneyFrame.this,"取款成功");
					}
					if(result==-3){
						JOptionPane.showMessageDialog(getMoneyFrame.this,"您的余额不足");
					}
					if (result==-4){
							JOptionPane.showMessageDialog(getMoneyFrame.this,"取款失败");
						}
					}
		});
		button_4.setBounds(22, 214, 95, 25);
		contentPane.add(button_4);
		
		 button_5 = new JButton("\u81EA\u5B9A\u4E49\u91D1\u989D");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMoneyFrame.this.dispose();
				freeGetMoneyFrame freeGet=new freeGetMoneyFrame();
				freeGet.setVisible(true);
			}
		});
		button_5.setFont(new Font("宋体", Font.PLAIN, 14));
		button_5.setBounds(323, 214, 109, 25);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMoneyFrame.this.dispose();
				selectFrame selFunction=new selectFrame();
				selFunction.setVisible(true);
			}
		});
		button_6.setFont(new Font("宋体", Font.PLAIN, 14));
		button_6.setBounds(22, 292, 109, 25);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("\u9000\u51FA");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component frame = null;
				int m=  JOptionPane.showConfirmDialog(frame,  "确定退出", "information",JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					       if (m == JOptionPane.OK_OPTION)
					          System.exit(0);
					          else if(m==JOptionPane.CANCEL_OPTION){
					    	   getMoneyFrame.this.dispose();
					    	   selectFrame frame1=new  selectFrame();
					    	   frame1.setVisible(true);
					       }
			}
				
		});
		button_7.setFont(new Font("宋体", Font.PLAIN, 14));
		button_7.setBounds(337, 292, 95, 25);
		contentPane.add(button_7);
	}
}
