package zct.edu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDB {
	
	static Connection conn=null;
	static Statement ps=null;
	static ResultSet rs=null;
	String Money;
	public void updateMoney(String uName,String money){	//ȡ��
		try{
			String sql="UPDATE atm SET yuer=yuer-'"+money+"' WHERE name='"+uName+"'";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			int text=ps.executeUpdate(sql);
			if(text ==1){
				System.out.println("���³ɹ�");
			}else{
				System.out.println("����ʧ��");
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
	}
	public void saveMoney(String uName,String money){		//���
		try{
			String sql="UPDATE atm SET yuer+='"+money+"' WHERE name='"+uName+"'";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			int text=ps.executeUpdate(sql);
			if(text ==1){
				System.out.println("���³ɹ�");
			}else{
				System.out.println("����ʧ��");
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
	}
	
	public void updatePassword(String uName,String password){		//��������
		try{
			String sql="UPDATE atm SET password='"+password+"' WHERE name='"+uName+"'";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			int text=ps.executeUpdate(sql);
			if(text ==1){
				System.out.println("���³ɹ�");
			}else{
				System.out.println("����ʧ��");
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
	}

	public void updateOp(String op,String id,String money,String time){		//����op
		try{
			
			String sql="Insert into ATMDetails  values ('"+id+"' ,'"+op+"','"+money+"','"+time+"') ";
			conn= ConnectionManager.getConn();
			ps = conn.createStatement();
			int text=ps.executeUpdate(sql);
			if(text ==1){
				System.out.println("���³ɹ�");
			}else{
				System.out.println("����ʧ��");
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
	}

	
}