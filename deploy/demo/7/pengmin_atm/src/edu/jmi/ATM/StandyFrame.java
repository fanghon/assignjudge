package edu.jmi.ATM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StandyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StandyFrame frame = new StandyFrame();
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
	public StandyFrame() {
		setTitle("\u5F85\u673A\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528ATM\u81EA\u52A8\u53D6\u6B3E\u673A");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		lblNewLabel.setBounds(133, 64, 170, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u8FDB\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    StandyFrame.this.dispose();
				LoginFrame loginframe=new LoginFrame();
				loginframe.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		btnNewButton.setBounds(75, 218, 95, 25);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(266, 218, 95, 25);
		contentPane.add(button);
	}
}
