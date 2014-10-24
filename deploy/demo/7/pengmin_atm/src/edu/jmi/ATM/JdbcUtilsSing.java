package edu.jmi.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcUtilsSing {

	private final static String driverURL="sun.jdbc.odbc.JdbcOdbcDriver";
	//private final static String databaseURL="jdbc:odbc:atm";
	private final static String databaseURL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
	private static JdbcUtilsSing instance=null;
	
	private String user="";
	private String password="";
	private JdbcUtilsSing(){
		
	}//µ¥ÀýÄ£Ê½
	public static JdbcUtilsSing getInstance(){
		if(instance==null){
			synchronized(JdbcUtilsSing.class){
				if(instance==null){
					instance=new JdbcUtilsSing();
				}
			}
		}
		return instance;
	}
	
	static{		
			try {
				Class.forName(driverURL);
			} catch (ClassNotFoundException e) {
				throw new ExceptionInInitializerError(e);
			}
	}
	
	public Connection getConnection() throws SQLException{
	
		return DriverManager.getConnection(databaseURL,user,password);
	}
    public void free(ResultSet rs,Statement st,Connection conn){
    		try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(st!=null)
						st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						if(conn!=null)
							conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
    
    }
}
