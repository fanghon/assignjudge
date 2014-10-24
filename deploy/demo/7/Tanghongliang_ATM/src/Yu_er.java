import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Yu_er extends JFrame {

	private JPanel contentPane;
	private JLabel yuer_1;
	private JLabel yuer_2;
	private MainGUI mgui = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yu_er frame = new Yu_er();
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
	public Yu_er() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) { 
				
				if(mgui!=null){
					yuer_1.setText("您当前的余额：" + mgui.user.getYuer());
					yuer_2.setText("可用余额： "+ mgui.user.getYuer());
				}
			}
		});
		setTitle("\u67E5\u8BE2\u4F59\u989D\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		yuer_1 = new JLabel("111");
		yuer_1.setHorizontalAlignment(SwingConstants.LEFT);
		yuer_1.setToolTipText("");
		yuer_1.setBounds(85, 66, 339, 15);
		contentPane.add(yuer_1);

		yuer_2 = new JLabel("111");
		yuer_2.setHorizontalAlignment(SwingConstants.LEFT);
		yuer_2.setBounds(109, 128, 339, 15);
		contentPane.add(yuer_2);

		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Yu_er.this.setVisible(false);
				if (Yu_er.this.mgui == null){
					MainGUI mgui = new MainGUI();
					mgui.setVisible(true);
				}else {
					Yu_er.this.mgui.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(10, 217, 109, 35);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDAO udo = new UserDAO();
				int res = JOptionPane.showConfirmDialog(Yu_er.this, "确定退出",
						"退出对话框", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION) {
					udo.delete();
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setBounds(315, 217, 109, 35);
		contentPane.add(btnNewButton_1);
	}

	public MainGUI getMgui() {
		return mgui;
	}

	public void setMgui(MainGUI mgui) {
		this.mgui = mgui;
	}
}
