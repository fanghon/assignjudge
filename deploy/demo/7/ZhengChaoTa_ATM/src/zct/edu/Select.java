package zct.edu;

import java.sql.*;
import java.util.ArrayList;
public class Select {
	static Connection conn=null;
	static Statement ps=null;
	static ResultSet rs=null;
	static ArrayList list=null;
	java.sql.Date time=null;
	
	public int selectInfo(String uName,String uPassw){		//重载
		try{
			String sql="select * from atm";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			rs=ps.executeQuery(sql);
			while(rs.next()){
				if(uName.equals(rs.getString("name")) && uPassw.equals(rs.getString("password"))){
					return 0;
				}
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
		return 1;
	}
	
	public int selectInfo(String uName){		//找用户名
		try{
			String sql="select * from atm where name='"+uName+"' ";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			rs=ps.executeQuery(sql);
			while(rs.next()){
				if(uName.equals(rs.getString("name"))) {
					return 0;	//找到就返回0
				}
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
		return 1;
	}
	public int selectPassword(String uName,String password){		//找密码
		try{
			String sql="select password from atm where name='"+uName+"' ";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			rs=ps.executeQuery(sql);
			while(rs.next()){
				if(password.equals(rs.getString("password"))) {
					return 0;	//找到就返回0
				}
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
		return 1;
	}
	/*
	public ArrayList selectJiaoyi(String id){		//找记录
		list=new ArrayList();
		try{
			String sql="select * from ATMDetails where Id='"+id+"' ";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			rs=ps.executeQuery(sql);
			while(rs.next()){
				String time1=rs.getString("Time");
				
				
				//java.util.Date utilDate =new java.util.Date(time.getTime());
				list.add( rs.getString("Operation")+"\t\t"+rs.getString("Qian")+"\t"+time1);	
				System.out.println(time1);
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
		return null;
	
	}*/

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
