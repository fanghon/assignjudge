package edu.jmi.ATM;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	ATMManager atmManager;
	static int i=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param str 
	 */
	public LoginFrame() {
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int windowsWedth=500;
		int windowsHeight=400;
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
		//setBounds(100, 100, 517, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u5361\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(47, 82, 133, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(47, 179, 133, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(184, 81, 171, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u7EE7\u7EED");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取输入的卡号和密码
				String user=textField.getText();
				//获取的密码是一个字符串数组
				String password=new String(passwordField.getPassword());
				//判断用户名、密码是否为空
				if(valideInput(user,password))
				{//如果用户名、密码不为空，则判断是否为合法的用户
					if(veryfyUser(user,password)){
						//判断是否是合法的用户，如果是合法的用户，则显示窗体
						LoginFrame.this.dispose();					
						selectFrame mainFrame = new selectFrame();
						mainFrame.setTitle("欢迎"+user+"光临！");
						mainFrame.setVisible(true);
					}
					else{//如果不是合法用户
						JOptionPane.showMessageDialog(LoginFrame.this,"用户名或密码错");
						i++;if(i>2){
							JOptionPane.showMessageDialog(LoginFrame.this,"超过次数，系统退出");
							System.exit(0);
					}
					}
				}
				else{//如用户名、密码为空
					
					JOptionPane.showMessageDialog(LoginFrame.this,"用户名或密码输入不能为空或空格");
				}
				
			}
		});
		btnNewButton.setBounds(67, 255, 95, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Component frame = null;
				   int m=  JOptionPane.showConfirmDialog(frame,  "确定退出", "information",JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					       if (m == JOptionPane.OK_OPTION)
					          System.exit(0);
					       else if(m==JOptionPane.CANCEL_OPTION){
					    	     LoginFrame.this.dispose();					
								selectFrame mainFrame = new selectFrame();
								  LoginFrame.this.show();
					       }
			}
		});
		btnNewButton_1.setBounds(351, 255, 95, 25);
		contentPane.add(btnNewButton_1);
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 176, 171, 21);
		contentPane.add(passwordField);
		
		atmManager = ATMManager.getIInstance();
	}
	//valideInput方法：用来判断用户名、密码是否为空
	 boolean valideInput(String user,String password){
	  boolean res=false;
	  if(user!=null&&!user.trim().equals("")&&password!=null&&!password.trim().equals(""))
		  //如果用户名不为空或用户名不为空格或者密码不为空，不为空格则返回true
		  return true;
	 return res;
	}
	boolean veryfyUser(String user,String password)
	{//veryfyUser方法 ：判断是否为合法的用户
		boolean res=false;
		/**if("pm".equals(user)&&"qaz1992".equals(password))
			return true; //用来测试输入		
		return res;
	 */
		UserRecord userRecord = new UserRecord();
		  userRecord.setUser(user);
		  userRecord.setPassword(password);
		   res=atmManager.validUser(userRecord);
		  return res;	 
	}
}
