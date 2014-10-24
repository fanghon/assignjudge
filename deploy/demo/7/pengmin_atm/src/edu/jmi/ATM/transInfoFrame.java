package edu.jmi.ATM;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;

import edu.jmi.DBAccess.DBAccess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transInfoFrame extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel_1 ;
	JLabel lblNewLabel_2; 
	 JTextArea textArea ;
	ATMManager atm;
	UserRecord userRecord;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transInfoFrame frame = new transInfoFrame();
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
	public transInfoFrame() {
		setTitle("\u663E\u793A\u4EA4\u6613\u8BB0\u5F55\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u8D26\u53F7\u4E3A\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(42, 23, 98, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F59\u989D\u4E3A\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(290, 23, 98, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(149, 23, 91, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(370, 23, 91, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("\u4EA4\u6613\u8BB0\u5F55\u4E3A\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(42, 61, 91, 41);
		contentPane.add(label); 
		 textArea = new JTextArea();	 
		 textArea.setToolTipText("");
		 atm= ATMManager.getIInstance();
		 UserRecord user=atm.getUser();
		  lblNewLabel_2.setText(user.getUser());
		  lblNewLabel_3.setText(atm.queryMoney()+"");

		textArea.setFont(new Font("宋体", Font.PLAIN, 14));
		
		 textArea.setBounds(44, 129, 540, 244);
		
		 contentPane.add(textArea);
		 
		 JButton btnNewButton = new JButton("\u8FD4\u56DE");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		transInfoFrame.this.dispose();
		 		selectFrame select=new selectFrame();
		 		select.setVisible(true);
		 	}
		 });
		 btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		 btnNewButton.setBounds(42, 406, 95, 25);
		 contentPane.add(btnNewButton);		 
		 JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		System.exit(0);
		 	}
		 });
		 btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		 btnNewButton_1.setBounds(430, 406, 95, 25);
		 contentPane.add(btnNewButton_1);
		 
		 JLabel lblNewLabel_5 = new JLabel("\u64CD\u4F5C\u7C7B\u578B");
		 lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 15));
		 lblNewLabel_5.setBounds(52, 99, 70, 26);
		 contentPane.add(lblNewLabel_5);
		 
		 JLabel lblNewLabel_6 = new JLabel("\u64CD\u4F5C\u91D1\u989D");
		 lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 15));
		 lblNewLabel_6.setBounds(216, 99, 91, 26);
		 contentPane.add(lblNewLabel_6);
		 
		 JLabel lblNewLabel_7 = new JLabel("\u64CD\u4F5C\u65F6\u95F4");
		 lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 15));
		 lblNewLabel_7.setBounds(415, 99, 70, 26);
		 contentPane.add(lblNewLabel_7);
		    int currId=atm.curruserId();
			DBAccess dba=new DBAccess();
			ATMDetails[] details=dba.getDetails(currId);
			String str = "";	
			for(int i=0;i<details.length;i++)
			{
				str = str+ details[i].getOperation()+"\t"+"\t"+"\t"+details[i].getMoney()+""+"\t"+"\t"+"\t"+details[i].getTime().toGMTString()+"\r\n";
				//textArea.append("\n");
			}
			 textArea.setText(str);

	
	}
}
