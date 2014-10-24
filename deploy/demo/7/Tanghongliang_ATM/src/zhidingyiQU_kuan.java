import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class zhidingyiQU_kuan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private MainGUI mgui = null;
	int m = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zhidingyiQU_kuan frame = new zhidingyiQU_kuan();
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
	public zhidingyiQU_kuan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u8BF7\u8F93\u5165\u60A8\u8981\u53D6\u6B3E\u7684\u91D1\u989D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 81, 162, 35);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(167, 88, 218, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton queding = new JButton("\u786E\u5B9A");
		queding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (mgui != null) {
					int n = 0;
					try{
					n = Integer.parseInt(textField.getText());
					if (n % 100 == 0 && n != 0 && n>0) {
						m = mgui.user.getYuer() - n;
						if (m >= 0) {
							mgui.user.setYuer(m);
							UserDAO ud = new UserDAO();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String s = df.format(new Date());
							ud.updateUser(mgui.user);
							ud.insertjilu("取款",""+n, s);
							JOptionPane.showMessageDialog(
									zhidingyiQU_kuan.this, "取款成功");
						} else {
							JOptionPane.showMessageDialog(
									zhidingyiQU_kuan.this, "您的余额不足");
						}
					} else {
						JOptionPane.showMessageDialog(zhidingyiQU_kuan.this,
								"取款金额必须为100的倍数");
					}
					}catch(Exception e){
						JOptionPane.showMessageDialog(
								zhidingyiQU_kuan.this, "输入不能为空");
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
				zhidingyiQU_kuan.this.setVisible(false);
				if (zhidingyiQU_kuan.this.mgui == null) {
					MainGUI mgui = new MainGUI();
					mgui.setVisible(true);
				} else {
					zhidingyiQU_kuan.this.mgui.setVisible(true);
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
