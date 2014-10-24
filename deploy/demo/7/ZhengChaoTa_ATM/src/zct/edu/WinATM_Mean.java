package zct.edu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WinATM_Mean extends JFrame {
	private ZhengChaoTa_Main aw=null;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	String name;

	public WinATM_Mean(final String name) {
		this.name=name;
		setTitle("欢迎"+name+"光临!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 352);
		setLocationRelativeTo(null);		//居中
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u60A8\u9700\u8981\u7684\u4E1A\u52A1");
		
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(145, 25, 149, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u4F59\u989D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WinMoney wmm=new WinMoney(name);
				wmm.setAm(WinATM_Mean.this);
				wmm.setVisible(true);		//打开WinMoney
				WinATM_Mean.this.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(39, 62, 104, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8F6C\u8D26");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(291, 62, 104, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u53D6\u6B3E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton_2.setBounds(39, 128, 104, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u663E\u793A\u4EA4\u6613\u8BB0\u5F55");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setBounds(291, 128, 104, 35);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5B58\u6B3E");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_4.setBounds(39, 189, 104, 35);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_5.setBounds(291, 189, 104, 35);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u8FD4\u56DE");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				//返回登陆界面
				WinATM_Mean.this.setVisible(false);;
				WinATM_Mean.this.aw.setVisible(true);
				
			}
		});
		btnNewButton_6.setBounds(39, 244, 104, 35);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\u9000\u51FA");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(WinATM_Mean.this, "确认退出",
						"退出对话框", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnNewButton_7.setBounds(291, 244, 104, 35);
		contentPane.add(btnNewButton_7);
	}

	public ZhengChaoTa_Main getAw() {
		return aw;
	}

	public void setAw(ZhengChaoTa_Main aw) {
		this.aw = aw;
	}

}
