import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zhuan_zhang extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private MainGUI mgui = null;
	String name = null;
	int n = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zhuan_zhang frame = new Zhuan_zhang();
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
	public Zhuan_zhang() {
		setTitle("\u8F6C\u8D26\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u8BF7\u8F93\u5165\u8F6C\u8D26\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(56, 62, 130, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"\u8BF7\u8F93\u5165\u8D26\u53F7\u91D1\u989D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(56, 124, 130, 15);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(169, 59, 163, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(169, 121, 163, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton fanhui = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		fanhui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 返回主界面
				Zhuan_zhang.this.setVisible(false);
				if (Zhuan_zhang.this.mgui == null) {
					MainGUI mgui = new MainGUI();
					mgui.setVisible(true);
				} else {
					Zhuan_zhang.this.mgui.setVisible(true);
				}
			}
		});
		fanhui.setBounds(10, 208, 105, 44);
		contentPane.add(fanhui);

		JButton tuichu = new JButton("\u9000\u51FA");
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDAO udo = new UserDAO();
				int res = JOptionPane.showConfirmDialog(Zhuan_zhang.this,
						"确定退出", "退出对话框", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION) {
					udo.delete();
					System.exit(0);
				}
			}
		});
		tuichu.setBounds(330, 208, 104, 44);
		contentPane.add(tuichu);

		JButton queding = new JButton("\u786E\u5B9A");
		queding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = textField.getText();
				if(name.length()!=0 && textField_1.getText().length()!=0){
				UserDAO ud = new UserDAO();
				User user1 = new User();
				user1 = ud.getUser(name);
				if (user1 != null) {
					n = Integer.parseInt(textField_1.getText());
					if (n % 100 == 0 && n != 0 && n > 0) {
						if (mgui.user.getYuer() - n >= 0) {
							mgui.user.setYuer(mgui.user.getYuer() - n);
							user1.setYuer(user1.getYuer() + n);
							ud.updateUser(mgui.user);
							ud.updateUser(user1);
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String s = df.format(new Date());
							ud.insertjilu("转账", ""+n, s);
							JOptionPane.showMessageDialog(Zhuan_zhang.this,
									"转账成功！");
						} else {
							JOptionPane.showMessageDialog(Zhuan_zhang.this,
									"您的余额不足！");
						}
					} else {
						JOptionPane.showMessageDialog(Zhuan_zhang.this,
								"转账金额必须为100的倍数！");
					}
				} else {
					JOptionPane.showMessageDialog(Zhuan_zhang.this, "转账账号不存在！");
				}}else{
					JOptionPane.showMessageDialog(Zhuan_zhang.this, "转账账号或金额不能为空！");
				}
			}
		});
		queding.setBounds(169, 174, 93, 23);
		contentPane.add(queding);
	}

	public MainGUI getMgui() {
		return mgui;
	}

	public void setMgui(MainGUI mgui) {
		this.mgui = mgui;
	}

}
