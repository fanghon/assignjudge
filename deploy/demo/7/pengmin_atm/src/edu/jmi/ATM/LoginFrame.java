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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setBounds(47, 82, 133, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(47, 179, 133, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(184, 81, 171, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u7EE7\u7EED");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ȡ����Ŀ��ź�����
				String user=textField.getText();
				//��ȡ��������һ���ַ�������
				String password=new String(passwordField.getPassword());
				//�ж��û����������Ƿ�Ϊ��
				if(valideInput(user,password))
				{//����û��������벻Ϊ�գ����ж��Ƿ�Ϊ�Ϸ����û�
					if(veryfyUser(user,password)){
						//�ж��Ƿ��ǺϷ����û�������ǺϷ����û�������ʾ����
						LoginFrame.this.dispose();					
						selectFrame mainFrame = new selectFrame();
						mainFrame.setTitle("��ӭ"+user+"���٣�");
						mainFrame.setVisible(true);
					}
					else{//������ǺϷ��û�
						JOptionPane.showMessageDialog(LoginFrame.this,"�û����������");
						i++;if(i>2){
							JOptionPane.showMessageDialog(LoginFrame.this,"����������ϵͳ�˳�");
							System.exit(0);
					}
					}
				}
				else{//���û���������Ϊ��
					
					JOptionPane.showMessageDialog(LoginFrame.this,"�û������������벻��Ϊ�ջ�ո�");
				}
				
			}
		});
		btnNewButton.setBounds(67, 255, 95, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Component frame = null;
				   int m=  JOptionPane.showConfirmDialog(frame,  "ȷ���˳�", "information",JOptionPane.OK_CANCEL_OPTION,
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
	//valideInput�����������ж��û����������Ƿ�Ϊ��
	 boolean valideInput(String user,String password){
	  boolean res=false;
	  if(user!=null&&!user.trim().equals("")&&password!=null&&!password.trim().equals(""))
		  //����û�����Ϊ�ջ��û�����Ϊ�ո�������벻Ϊ�գ���Ϊ�ո��򷵻�true
		  return true;
	 return res;
	}
	boolean veryfyUser(String user,String password)
	{//veryfyUser���� ���ж��Ƿ�Ϊ�Ϸ����û�
		boolean res=false;
		/**if("pm".equals(user)&&"qaz1992".equals(password))
			return true; //������������		
		return res;
	 */
		UserRecord userRecord = new UserRecord();
		  userRecord.setUser(user);
		  userRecord.setPassword(password);
		   res=atmManager.validUser(userRecord);
		  return res;	 
	}
}
