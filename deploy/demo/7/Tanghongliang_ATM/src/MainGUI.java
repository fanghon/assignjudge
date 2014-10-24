import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private zhuGUI zgui = null;
	User user = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				// 设置窗口标题
				if (zgui != null) {
					MainGUI.this.user = zgui.user;
					MainGUI.this.setTitle("欢迎" + zgui.user.getName());
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u8BF7\u9009\u62E9\u60A8\u9700\u8981\u7684\u4E1A\u52A1\r\n");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 34, 434, 44);
		contentPane.add(lblNewLabel);

		JButton chaxun = new JButton("\u67E5\u8BE2\u4F59\u989D");
		chaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 查询余额
				Yu_er yu = new Yu_er();
				yu.setMgui(MainGUI.this);
				yu.setVisible(true);
				MainGUI.this.setVisible(false);
			}
		});
		chaxun.setBounds(46, 100, 120, 44);
		contentPane.add(chaxun);

		JButton qukuan = new JButton("\u53D6\u6B3E");
		qukuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Qu_kuan qukuan = new Qu_kuan();
				qukuan.setVisible(true);
				qukuan.setMgui(MainGUI.this);
				MainGUI.this.setVisible(false);
			}
		});
		qukuan.setBounds(46, 169, 120, 44);
		contentPane.add(qukuan);

		JButton cunkuan = new JButton("\u5B58\u6B3E");
		cunkuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 存款;
				Cun_kuan cun_kuan = new Cun_kuan();
				cun_kuan.setMgui(MainGUI.this);
				cun_kuan.setVisible(true);
				MainGUI.this.setVisible(false);
			}
		});
		cunkuan.setBounds(46, 238, 120, 44);
		contentPane.add(cunkuan);

		JButton fanhui = new JButton("\u8FD4\u56DE");
		fanhui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 返回zhuGUI
				MainGUI.this.setVisible(false); // 关闭主窗口
				if (MainGUI.this.zgui == null) {
					zhuGUI lgui = new zhuGUI();
					lgui.setVisible(true); //
				} else {
					MainGUI.this.zgui.setVisible(true); // 显示登录窗口
				}
			}
		});
		fanhui.setBounds(10, 324, 105, 44);
		contentPane.add(fanhui);

		JButton zhuanzhang = new JButton("\u8F6C\u8D26");
		zhuanzhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Zhuan_zhang zhuan_zhang = new Zhuan_zhang();
				zhuan_zhang.setMgui(MainGUI.this);
				zhuan_zhang.setVisible(true);
				MainGUI.this.setVisible(false);
			}
		});
		zhuanzhang.setBounds(267, 100, 120, 44);
		contentPane.add(zhuanzhang);

		JButton xianshi = new JButton("\u663E\u793A\u4EA4\u6613\u8BB0\u5F55");
		xianshi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JIAOYI_jilu jiaoyi_jilu = new JIAOYI_jilu();
				jiaoyi_jilu.setMgui(MainGUI.this);
				jiaoyi_jilu.setVisible(true);
				MainGUI.this.setVisible(false);
			}
		});
		xianshi.setBounds(267, 169, 120, 44);
		contentPane.add(xianshi);

		JButton xiugai = new JButton("\u4FEE\u6539\u5BC6\u7801");
		xiugai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Xiugai xiugai = new Xiugai();
				xiugai.setVisible(true);
				xiugai.setMgui(MainGUI.this);
				MainGUI.this.setVisible(false);
			}
		});
		xiugai.setBounds(267, 238, 120, 44);
		contentPane.add(xiugai);

		JButton tuichu = new JButton("\u9000\u51FA");
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDAO udo = new UserDAO();
				int res = JOptionPane.showConfirmDialog(MainGUI.this, "确定退出",
						"退出对话框", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION) {
					udo.delete();
					System.exit(0);
				}
			}
		});
		tuichu.setBounds(319, 324, 105, 44);
		contentPane.add(tuichu);
	}

	public zhuGUI getZgui() {
		return zgui;
	}

	public void setZgui(zhuGUI zgui) {
		this.zgui = zgui;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
