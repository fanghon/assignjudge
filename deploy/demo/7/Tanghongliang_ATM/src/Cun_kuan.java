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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cun_kuan extends JFrame {

	private JPanel contentPane;
	private MainGUI mgui = null;
	private JTextField textField;
	int m = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cun_kuan frame = new Cun_kuan();
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
	public Cun_kuan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u8BF7\u8F93\u5165\u5B58\u6B3E\u91D1\u989D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(58, 76, 160, 15);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(167, 73, 171, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton queding = new JButton("\u786E\u5B9A");
		queding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (mgui != null) {
					int n = 0;
					try {
						n = Integer.parseInt(textField.getText());
						if (n % 100 == 0 && n != 0 && n > 0) {
							m = mgui.user.getYuer() + n;
							mgui.user.setYuer(m);
							UserDAO ud = new UserDAO();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String s = df.format(new Date());
							ud.updateUser(mgui.user);
							ud.insertjilu("存款", ""+n, s);
							JOptionPane
									.showMessageDialog(Cun_kuan.this, "存款成功");
						} else {
							JOptionPane.showMessageDialog(Cun_kuan.this,
									"存款金额必须为100的倍数");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(Cun_kuan.this, "输入不能为空");
					}
				}
			}
		});
		queding.setBounds(10, 208, 105, 44);
		contentPane.add(queding);

		JButton fanhui = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		fanhui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//返回主界面
				Cun_kuan.this.setVisible(false);
				if (Cun_kuan.this.mgui == null) {
					MainGUI mgui = new MainGUI();
					mgui.setVisible(true);
				} else {
					Cun_kuan.this.mgui.setVisible(true);
				}
			}
		});
		fanhui.setBounds(319, 208, 105, 44);
		contentPane.add(fanhui);
	}

	public MainGUI getMgui() {
		return mgui;
	}

	public void setMgui(MainGUI mgui) {
		this.mgui = mgui;
	}
}
