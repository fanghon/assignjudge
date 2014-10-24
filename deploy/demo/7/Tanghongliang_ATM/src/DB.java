import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DB {

	/**
	 * @param args
	 */
	//������
	private static final String  DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	//
	//���ݿ�·��
	private static final String URL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
	//
	private static final String URL1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./jilu.mdb";
	//�����������������ݿ�
	public static Connection getConnection(){
		 Connection conn = null;
		 try
		{
			Class.forName(DRIVER);  //������������������
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("���ݿ���������ʧ��");
			return null;
		}	 
		  try
		{
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
		 
		 return conn;
	  }
	
	
	
	//
	public static Connection gC(){
		 Connection conn = null;
		 try
		{
			Class.forName(DRIVER);  //������������������
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("���ݿ���������ʧ��");
			return null;
		}	 
		  try
		{
			conn = DriverManager.getConnection(URL1);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
		 
		 return conn;
	  }
	
	
	
	//�ر��α꣬SQL���ͶϿ����ݿ�
	public static void close(ResultSet  rs, PreparedStatement pst,Connection conn){
		 try
			{
				if(rs!=null)
				 rs.close();
				if(pst!=null)
				 pst.close();
				if(conn!=null)
				 conn.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	  
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
