import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DB {

	/**
	 * @param args
	 */
	//驱动名
	private static final String  DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	//
	//数据库路径
	private static final String URL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
	//
	private static final String URL1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./jilu.mdb";
	//加载驱动和连接数据库
	public static Connection getConnection(){
		 Connection conn = null;
		 try
		{
			Class.forName(DRIVER);  //根据驱动名加载驱动
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("数据库驱动加载失败");
			return null;
		}	 
		  try
		{
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		 
		 return conn;
	  }
	
	
	
	//
	public static Connection gC(){
		 Connection conn = null;
		 try
		{
			Class.forName(DRIVER);  //根据驱动名加载驱动
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("数据库驱动加载失败");
			return null;
		}	 
		  try
		{
			conn = DriverManager.getConnection(URL1);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		 
		 return conn;
	  }
	
	
	
	//关闭游标，SQL语句和断开数据库
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
