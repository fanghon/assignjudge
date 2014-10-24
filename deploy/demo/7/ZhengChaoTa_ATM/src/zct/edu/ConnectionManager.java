package zct.edu;

import java.sql.*;
public class ConnectionManager{

	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;	

	public static Connection getConn(){
		Connection conn=null;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
			conn = DriverManager.getConnection(url);
			System.out.println("数据库连接成功!");
		} catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String [] args){
		Connection conn=null;
		conn=ConnectionManager.getConn();
		
		
	}
}