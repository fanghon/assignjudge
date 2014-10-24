package zct.edu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

//注：此项目只为通过测试，只提供查询功能。

public class ZhengChaoTa_Main extends JFrame {
	static int count=0;  		//登陆的次数
	static String name;
	private JPanel contentPane;
	 JTextField textField;
	private JPasswordField passwordField;
	private JButton button;
	private static ZhengChaoTa_Main frame = new ZhengChaoTa_Main();		//窗体
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
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
	public ZhengChaoTa_Main() {
		 
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		 Toolkit tk = Toolkit.getDefaultToolkit();
		 setLocationRelativeTo(null);	//居中
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u5361\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(29, 53, 120, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(29, 142, 112, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();

		textField.setBounds(223, 50, 155, 21);
	
		contentPane.add(textField);
		textField.setColumns(10);
		
		button = new JButton("\u7EE7\u7EED");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd=arg0.getActionCommand();//捕获指令
				
				Select select=new Select();
				
				char [] chars=passwordField.getPassword();
				 String password=new String(chars);
				
				if(cmd.equals("继续")){
					if(textField.getText().trim().equals("") || password.equals("")){		//如果其中一个文本框中没输入则将会提示
						JOptionPane.showMessageDialog(ZhengChaoTa_Main.this,"用户名或密码输入不能为空或空格");						
					}else if(select.selectInfo(textField.getText().trim(),password)==0){
						name=textField.getText();
						WinATM_Mean am=new WinATM_Mean(name);
						am.setAw(ZhengChaoTa_Main.this);
						am.setVisible(true);
						ZhengChaoTa_Main.this.setVisible(false);
						
						UpdateDB db=new UpdateDB();
						//db.updateId(Id);		//更新TextDetails表中的Id
						textField.setText("");
						passwordField.setText("");
						
					}else{
						count++;
						if(count==4){
							JOptionPane.showMessageDialog(ZhengChaoTa_Main.this, "超过登陆次数系统退出");
							System.exit(-1);
						}else{
							JOptionPane.showMessageDialog(ZhengChaoTa_Main.this, "用户名或密码错误");
						}
					}
				}
			}
		});
		button.setBounds(80, 207, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg1) {
				String cmd1=arg1.getActionCommand();
				if(cmd1.equals("退出")){
					int res = JOptionPane.showConfirmDialog(ZhengChaoTa_Main.this, "确认退出",
							"退出对话框", JOptionPane.OK_CANCEL_OPTION);
					if (res == JOptionPane.OK_OPTION)
					{
						System.exit(0);
					}

				}
			}
		});
		button_1.setBounds(257, 207, 93, 23);
		contentPane.add(button_1);
		
		passwordField = new JPasswordField(); 
		passwordField.setBounds(223, 139, 155, 21);
		contentPane.add(passwordField);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		ZhengChaoTa_Main.name = name;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		ZhengChaoTa_Main.count = count;
	}



	
}
