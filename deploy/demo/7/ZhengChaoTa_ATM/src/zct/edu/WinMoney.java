package zct.edu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WinMoney extends JFrame {
	private WinATM_Mean am=null;
	private ZhengChaoTa_Main aw=null;
	private JPanel contentPane;

	String name;
	public WinMoney(final String name) {
		this.name=name;
		//System.out.println(name);		//测试是否为 null
		//System.out.println(name);		//测试是否为 null
		setTitle("\u67E5\u8BE2\u4F59\u989D\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 254);
		setLocationRelativeTo(null);	//居中
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(97, 51, 36, 6);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u60A8\u5F53\u524D\u7684\u4F59\u989D\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(10, 48, 105, 23);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u53EF\u7528\u4F59\u989D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 110, 70, 15);
		contentPane.add(lblNewLabel);
		
		//查指定用户的钱
		selectMoney sm=new selectMoney();
		 String money=sm.selectMoney(name);
		//System.out.println(name);		测试是否为 null
		 
		JLabel lblNewLabel_1 = new JLabel(money);
		lblNewLabel_1.setBounds(224, 56, 86, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(money);
		lblNewLabel_2.setBounds(224, 110, 86, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				WinMoney.this.setVisible(false);	
				WinMoney.this.am.setVisible(true);
				/*
				ATM_Mean aa=new ATM_Mean(name);  //显示登录窗口 	
				aa.setTitle("");
				aa.setVisible(true);		
			*/
			}
		});
		btnNewButton.setBounds(74, 157, 106, 35);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(WinMoney.this, "确认退出",
						"退出对话框", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION)
				{
					System.exit(0);
				}
				
			}
		});
		button.setBounds(239, 157, 106, 35);
		contentPane.add(button);
	}

	public WinATM_Mean getAm() {
		return am;
	}

	public void setAm(WinATM_Mean am) {
		this.am = am;
	}

	public ZhengChaoTa_Main getAw() {
		return aw;
	}

	public void setAw(ZhengChaoTa_Main aw) {
		this.aw = aw;
	}


}
