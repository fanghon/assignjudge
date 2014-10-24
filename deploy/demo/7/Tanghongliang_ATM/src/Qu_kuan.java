import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Qu_kuan extends JFrame {

	private JPanel contentPane;
	private MainGUI mgui = null;
	int m = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qu_kuan frame = new Qu_kuan();
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
	public Qu_kuan() {	
		setTitle("\u53D6\u6B3E\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton b_100 = new JButton("100");
		b_100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mgui!=null){
				m=mgui.user.getYuer()-100;
				if(m>=0){
				mgui.user.setYuer(m);
				UserDAO ud =new UserDAO();
				ud.updateUser(mgui.user);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s = df.format(new Date());
				ud.insertjilu("取款", "100", s);
				JOptionPane.showMessageDialog(Qu_kuan.this,"取款成功");
				}else{
					JOptionPane.showMessageDialog(Qu_kuan.this,"您的余额不足");
				}
				}
			}
		});
		b_100.setBounds(53, 84, 112, 23);
		contentPane.add(b_100);
		
		JButton b_300 = new JButton("300");
		b_300.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mgui!=null){
				m=mgui.user.getYuer()-300;
				if(m>=0){
				mgui.user.setYuer(m);
				UserDAO ud =new UserDAO();
				ud.updateUser(mgui.user);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s = df.format(new Date());
				ud.insertjilu("取款", "300", s);
				JOptionPane.showMessageDialog(Qu_kuan.this,"取款成功");
				}else{
					JOptionPane.showMessageDialog(Qu_kuan.this,"您的余额不足");
				}
				}
			}
		});
		b_300.setBounds(53, 128, 112, 23);
		contentPane.add(b_300);
		
		JButton b_500 = new JButton("500");
		b_500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mgui!=null){
				m=mgui.user.getYuer()-500;
				if(m>=0){
				mgui.user.setYuer(m);
				UserDAO ud =new UserDAO();
				ud.updateUser(mgui.user);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s = df.format(new Date());
				ud.insertjilu("取款", "500", s);
				JOptionPane.showMessageDialog(Qu_kuan.this,"取款成功");
				}else{
					JOptionPane.showMessageDialog(Qu_kuan.this,"您的余额不足");
				}
				}
			}
		});
		b_500.setBounds(53, 178, 112, 23);
		contentPane.add(b_500);
		
		JButton 返回 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		返回.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//返回
				Qu_kuan.this.setVisible(false);
				if (Qu_kuan.this.mgui == null){
				MainGUI mgui = new MainGUI();
				mgui.setVisible(true);
			}else {
				Qu_kuan.this.mgui.setVisible(true);
			}
			}
		});
		返回.setBounds(10, 235, 105, 44);
		contentPane.add(返回);
		
		JButton b_200 = new JButton("200");
		b_200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mgui!=null){
				m=mgui.user.getYuer()-200;
				if(m>=0){
				mgui.user.setYuer(m);
				UserDAO ud =new UserDAO();
				ud.updateUser(mgui.user);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s = df.format(new Date());
				ud.insertjilu("取款", "200", s);
				JOptionPane.showMessageDialog(Qu_kuan.this,"取款成功");
				}else{
					JOptionPane.showMessageDialog(Qu_kuan.this,"您的余额不足");
				}
				}
			}
		});
		b_200.setBounds(270, 84, 112, 23);
		contentPane.add(b_200);
		
		JButton b_400 = new JButton("400");
		b_400.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mgui!=null){
				m=mgui.user.getYuer()-400;
				if(m>=0){
				mgui.user.setYuer(m);
				UserDAO ud =new UserDAO();
				ud.updateUser(mgui.user);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String s = df.format(new Date());
				ud.insertjilu("取款", "400", s);
				JOptionPane.showMessageDialog(Qu_kuan.this,"取款成功");
				}else{
					JOptionPane.showMessageDialog(Qu_kuan.this,"您的余额不足");
				}
				}
			}
		});
		b_400.setBounds(270, 128, 112, 23);
		contentPane.add(b_400);
		
		JButton zidingyi = new JButton("\u81EA\u5B9A\u4E49\u91D1\u989D");
		zidingyi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				zhidingyiQU_kuan zdy = new zhidingyiQU_kuan();
				zdy.setMgui(mgui);
				zdy.setVisible(true);
				Qu_kuan.this.setVisible(false);
			}
		});
		zidingyi.setBounds(270, 178, 112, 23);
		contentPane.add(zidingyi);
		
		JButton tuichu = new JButton("\u9000\u51FA");
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDAO udo = new UserDAO();
				int res = JOptionPane.showConfirmDialog(Qu_kuan.this, "确定退出",
						"退出对话框", JOptionPane.OK_CANCEL_OPTION);
				if (res == JOptionPane.OK_OPTION) {
					udo.delete();
					System.exit(0);
				}
			}
		});
		tuichu.setBounds(319, 235, 105, 44);
		contentPane.add(tuichu);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u53D6\u6B3E\u91D1\u989D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 32, 414, 42);
		contentPane.add(lblNewLabel);
	}

	public MainGUI getMgui() {
		return mgui;
	}

	public void setMgui(MainGUI mgui) {
		this.mgui = mgui;
	}


}
