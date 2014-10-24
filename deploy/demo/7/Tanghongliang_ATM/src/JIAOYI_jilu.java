import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JIAOYI_jilu extends JFrame {

	private JPanel contentPane;
	private MainGUI mgui = null;
	private JLabel yuer_1;
	private JLabel name_1;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIAOYI_jilu frame = new JIAOYI_jilu();
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
	public JIAOYI_jilu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				String s = "";
				name_1.setText(mgui.user.getName());
				yuer_1.setText("" + mgui.user.getYuer());
				UserDAO ud =new UserDAO();
				String[][] str=ud.xianshi();
				for(int i =0;i<20;i++){
				s=s+("  "+str[i][0]+"                           "+str[i][1]+"                         "+str[i][2]+"\n");
				}
				textPane.setText(s);
			}
		});
		setTitle("\u663E\u793A\u4EA4\u6613\u8BB0\u5F55\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u8D26\u53F7\u4E3A\uFF1A");
		lblNewLabel.setBounds(33, 40, 86, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u4F59\u989D\u4E3A\uFF1A");
		lblNewLabel_1.setBounds(255, 40, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"\u4EA4\u6613\u8BB0\u5F55\u4E3A\uFF1A");
		lblNewLabel_2.setBounds(33, 65, 86, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u64CD\u4F5C\u7C7B\u578B");
		lblNewLabel_3.setBounds(43, 90, 54, 15);
		contentPane.add(lblNewLabel_3);

		textPane = new JTextPane();
		textPane.setBounds(33, 115, 389, 206);
		contentPane.add(textPane);

		name_1 = new JLabel("New label");
		name_1.setBounds(106, 40, 54, 15);
		contentPane.add(name_1);

		yuer_1 = new JLabel("New label");
		yuer_1.setBounds(302, 40, 54, 15);
		contentPane.add(yuer_1);

		JButton fanhui = new JButton("\u8FD4\u56DE");
		fanhui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JIAOYI_jilu.this.setVisible(false);
				if (JIAOYI_jilu.this.mgui == null) {
					MainGUI mgui = new MainGUI();
					mgui.setVisible(true);
				} else {
					JIAOYI_jilu.this.mgui.setVisible(true); // 显示登录窗口
				}
			}
		});
		fanhui.setBounds(10, 331, 105, 44);
		contentPane.add(fanhui);

		JButton tuichu = new JButton("\u9000\u51FA");
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDAO udo = new UserDAO();
				int res = JOptionPane.showConfirmDialog(JIAOYI_jilu.this,
						"确定退出", "退出对话框", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION) {
					udo.delete();
					System.exit(0);
				}
			}
		});
		tuichu.setBounds(338, 331, 105, 44);
		contentPane.add(tuichu);

		JLabel lblNewLabel_4 = new JLabel("\u64CD\u4F5C\u91D1\u989D");
		lblNewLabel_4.setBounds(139, 90, 54, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u64CD\u4F5C\u65F6\u95F4");
		lblNewLabel_5.setBounds(255, 90, 54, 15);
		contentPane.add(lblNewLabel_5);
	}

	public MainGUI getMgui() {
		return mgui;
	}

	public void setMgui(MainGUI mgui) {
		this.mgui = mgui;
	}

}
