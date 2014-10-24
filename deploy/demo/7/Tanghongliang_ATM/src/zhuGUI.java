import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class zhuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JPasswordField txt_password;
	User user =null;
	int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zhuGUI frame = new zhuGUI();
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
	public zhuGUI() {
		getContentPane().setLayout(null);
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton jixu = new JButton("\u7EE7\u7EED");
		jixu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ��ȡ�˺ź�����
				String name = txt_name.getText();
				char[] chars = txt_password.getPassword();
				String password = new String(chars);
				//

				// ��֤�ǿ� �����볤�Ȳ�С��6
				if (name.trim().length() == 0 || password.trim().length() == 0) {
					count++;
					if (count <= 2) {
						JOptionPane.showMessageDialog(zhuGUI.this, "���벻��Ϊ��");
					}
					if (count > 2) {
						JOptionPane.showMessageDialog(zhuGUI.this,
								"��¼���볬�������������˳�");
						System.exit(0);
					}
					//
					// ���볤�Ȳ�С��6
				} else if (password.length() < 6) {
					count++;
					if (count <= 2) {
						JOptionPane.showMessageDialog(zhuGUI.this, "����С��6λ");
					}
					if (count > 2) {
						JOptionPane.showMessageDialog(zhuGUI.this,
								"��¼���볬�������������˳�");
						System.exit(0);
					}
				}
				//
				//
				else if (true) {
					UserDAO ud =new UserDAO();
					name = txt_name.getText();
					User user = ud.getUser(name);
					if (user!=null && user.getPassword().equals(password) && user.getName().equals(name) ) {
						zhuGUI.this.user =user;
						MainGUI maingui = new MainGUI();
						maingui.setZgui(zhuGUI.this);
						maingui.setVisible(true);
						zhuGUI.this.setVisible(false);

						txt_name.setText("");
						txt_password.setText("");

					} else {
						count++;
						if (count <= 2) {
							JOptionPane.showMessageDialog(zhuGUI.this,
									"�û������������");
							txt_name.setText(""); // ����û���
							txt_password.setText("");
						}
						if (count > 2) {
							JOptionPane.showMessageDialog(zhuGUI.this,
									"��¼���볬�������������˳�");
							System.exit(0);
						}
					}
				}
			}
		});
		jixu.setBounds(105, 177, 80, 23);
		contentPane.add(jixu);

		JButton tuichu = new JButton("\u9000\u51FA");
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDAO udo = new UserDAO();
				int res = JOptionPane.showConfirmDialog(zhuGUI.this, "ȷ���˳�",
						"�˳��Ի���", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION) {
					udo.delete();
					System.exit(0);
				}
			}
		});
		tuichu.setBounds(237, 177, 80, 23);
		contentPane.add(tuichu);

		txt_name = new JTextField();
		txt_name.setBounds(171, 59, 162, 21);
		contentPane.add(txt_name);
		txt_name.setColumns(10);

		JLabel lblNewLabel = new JLabel(
				"\u8BF7\u8F93\u5165\u60A8\u7684\u5361\u53F7\uFF1A");
		lblNewLabel.setBounds(67, 62, 106, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel(
				"\u8BF7\u8F93\u5165\u60A8\u7684\u5BC6\u7801\uFF1A");
		label.setBounds(67, 130, 106, 15);
		contentPane.add(label);

		txt_password = new JPasswordField();
		txt_password.setToolTipText("");
		txt_password.setBounds(171, 127, 162, 21);
		contentPane.add(txt_password);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
