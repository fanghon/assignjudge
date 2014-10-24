package zct.edu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class selectMoney {
	static Connection conn=null;
	static Statement ps=null;
	static ResultSet rs=null;
	String Money;
	public String selectMoney(String uName){
		try{
			String sql="select yuer from atm where name='"+uName+"'";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			rs=ps.executeQuery(sql);
			while(rs.next()){
					String Money=rs.getString("yuer");
					return Money;		//·µ»Ø½ðÇ®
				}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)conn.close();
				if(ps!=null)conn.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Money;
	}
}
