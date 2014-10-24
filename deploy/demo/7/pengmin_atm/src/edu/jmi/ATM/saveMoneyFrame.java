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
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(36, 63, 137, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 14));
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
				
				//���أ�1 �ɹ���-1��ʾ����100�ı���������-2����ʾ����10000��-4 ��Ǯʧ��
		        int result=atm.saveMoney(money);
				if(result==1){
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"���ɹ�");
				}
				if(result==-1){
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"��������Ϊ100�ı���");
				}
				if(result==-2){
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"�����ܳ���10000");
				}
				if(result==-4){
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"���ʧ��");
				}
				}
				else{
					JOptionPane.showMessageDialog(saveMoneyFrame.this,"���벻��Ϊ��");
				}
			}			
		});
		button.setFont(new Font("����", Font.PLAIN, 14));
		button.setBounds(38, 212, 95, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button_1.setFont(new Font("����", Font.PLAIN, 14));
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
