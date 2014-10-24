import java.awt.BorderLayout;
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
import javax.swing.JPasswordField;

public class Xiugai extends JFrame {

	private JPanel contentPane;
	private MainGUI mgui = null;
	private JPasswordField txt_old;
	private JPasswordField txt_new1;
	private JPasswordField txt_new2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xiugai frame = new Xiugai();
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
	public Xiugai() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u8BF7\u8F93\u5165\u60A8\u7684\u539F\u59CB\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel.setBounds(57, 36, 144, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"\u8BF7\u8F93\u5165\u60A8\u7684\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(73, 94, 124, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"\u8BF7\u8F93\u5165\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(87, 125, 124, 15);
		contentPane.add(lblNewLabel_2);

		JButton fanhui = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		fanhui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Xiugai.this.setVisible(false);
				if (Xiugai.this.mgui == null) {
					MainGUI mgui = new MainGUI();
					mgui.setVisible(true);
				} else {
					Xiugai.this.mgui.setVisible(true);
				}
			}
		});
		fanhui.setBounds(10, 207, 105, 44);
		contentPane.add(fanhui);

		JButton tuichu = new JButton("\u9000\u51FA");
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDAO udo = new UserDAO();
				int res = JOptionPane.showConfirmDialog(Xiugai.this, "确定退出",
						"退出对话框", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION) {
					udo.delete();
					System.exit(0);
				}
			}
		});
		tuichu.setBounds(319, 207, 105, 44);
		contentPane.add(tuichu);

		JButton queding = new JButton("\u786E\u5B9A");
		queding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				char[] charold = txt_old.getPassword();
				String old = new String(charold);

				char[] charnew1 = txt_new1.getPassword();
				String new_1 = new String(charnew1);

				char[] charnew2 = txt_new2.getPassword();
				String new_2 = new String(charnew2);
				if (old.trim().length() == 0 || new_1.trim().length() == 0
						|| new_2.trim().length() == 0) {
					JOptionPane.showMessageDialog(Xiugai.this, "密码不能为空！");
				} else if (old.length() != 6 || new_1.length() != 6
						|| new_2.length() != 6) {
					JOptionPane.showMessageDialog(Xiugai.this, "密码长度应为6位数！");
				} else if (true) {
					if (mgui.user.getPassword().equals(old)) {
						if (new_1.equals(new_2)) {
							mgui.user.setPassword(new_1);
							User user = new User();
							user = mgui.user;
							UserDAO ud = new UserDAO();
							ud.updateUserMima(user);
							JOptionPane.showMessageDialog(Xiugai.this,
									"密码修改成功！");
						} else {
							JOptionPane.showMessageDialog(Xiugai.this,
									"新密码与确认密码应一致！");
						}
					} else {
						JOptionPane.showMessageDialog(Xiugai.this, "原密码错！");
					}

				}
			}
		});
		queding.setBounds(165, 179, 93, 23);
		contentPane.add(queding);

		txt_old = new JPasswordField();
		txt_old.setToolTipText("");
		txt_old.setBounds(197, 33, 124, 21);
		contentPane.add(txt_old);

		txt_new1 = new JPasswordField();
		txt_new1.setBounds(197, 91, 124, 21);
		contentPane.add(txt_new1);

		txt_new2 = new JPasswordField();
		txt_new2.setBounds(197, 122, 124, 21);
		contentPane.add(txt_new2);
	}

	public MainGUI getMgui() {
		return mgui;
	}

	public void setMgui(MainGUI mgui) {
		this.mgui = mgui;
	}
}
