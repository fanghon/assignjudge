package edu.jmi.DBAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.jmi.ATM.ATMDetails;
import edu.jmi.ATM.JdbcUtilsSing;

import edu.jmi.ATM.UserRecord;
/**
数据存取类：负责数据库的连接、关闭，数据的获取、更新、添加
*/
public class DBAccess {  
	
	
	public UserRecord getUserRecord(String name){
		/**
		 *    根据用户名字获取用户记录，若无则返回null
		 */
		UserRecord user=null;
    	try {
			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
			Connection conn=jdbc.getConnection();   	
			String sql="select * from atm where name=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				String user1=rs.getString("name");
				String password1=rs.getString("password");
				int yuer1=rs.getInt("yuer");
				user=new UserRecord(user1,password1,yuer1);
			}
			jdbc.free(null, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;				
	}
	public int updateUserRecord(UserRecord user){
		/** 更新指定用户的信息（可能是余额，也可能是密码）
                                 成功返回 1，失败返回-1； */
		int res=0;
		return res;
	}
	public int addDetailsRecord(ATMDetails ad){
		/**  添加一条交易操作记录，若成功返回操作的ID号，失败返回-1
                                    注意一次登录多次操作的ID号是相同的。传入的ad对象中的id如果大于0，则使用该
             id添加记录，否则需要查询表中的当前最大id号，加1后，作为本次操作的id号写入记录，同时返回
                                     该最新的id号，业务处理层应将该有效id保存在当前交易id号中。
		 */
		int res = -1;
		 try {
			JdbcUtilsSing jdbc =  JdbcUtilsSing.getInstance(); 
			 Connection conn = jdbc.getConnection();   
			 String sql ="insert into ATMDetails values(?,?,?,?)";
			 PreparedStatement pst = conn.prepareStatement(sql);
			 pst.setInt(1, ad.getId());
			 pst.setString(2, ad.getOperation());
			 pst.setInt(3, ad.getMoney());
			pst.setDate(4,ad.getTime());		 		 
			 res = pst.executeUpdate();  
			 res=ad.getId();
			 jdbc.free(null, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//res = -1;
		}		
		return res;
	}
			
	
	public ATMDetails[] getDetails(int id){
		/** 根据id号获取交易明细记录集合，如无则返回null。
		 */
		DBAccess dba=new DBAccess();
		int num=dba.Count(id);
		ATMDetails[] details =new ATMDetails[num];
		try {
			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
			Connection conn=jdbc.getConnection();  
			PreparedStatement pst = null;
			ResultSet rs=null;
			for( int i=0;i<details.length;){	
				String sql="select * from ATMDetails where id="+id;				
			     pst=conn.prepareStatement(sql);
				 rs=pst.executeQuery();
				while(rs.next()){
					int transId=rs.getInt("id");
					String transType=rs.getString("operation");
					int transMoney=rs.getInt("money");
					Date transTime=rs.getDate("time");
					details[i]=new ATMDetails(transId,transType,transMoney, transTime);	
					i++;
			}
			}	
				jdbc.free(rs, pst, conn);
		  }
			 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return details;		
	}
	
	public int getMaxID(){
		//查询交易记录表中的最大ID,空表id返回0；获取最大id的目的是：避免重复
		int res=0;
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
			conn=jdbc.getConnection();   			
	        st=conn.createStatement();
	        String sql="select max(id)as maxId from ATMDetails";
 		    rs=st.executeQuery(sql);	
 		   while(rs.next()){
 			res=rs.getInt("maxId");
 		   }			     
			jdbc.free(rs, st, conn);
		   } catch (SQLException e) {	
			   e.printStackTrace();
		   }
		return res;
	}
	//获取交易记录量的方法
	public int Count(int id){
		int res=0;
		try {
			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
			Connection conn=jdbc.getConnection();  
			PreparedStatement pst = null;
			ResultSet rs=null;		
				String sql="select count(*) as num from ATMDetails where id="+id;				
			     pst=conn.prepareStatement(sql);
				 rs=pst.executeQuery();
				 while(rs.next()){
					res=rs.getInt("num");
			}
				jdbc.free(rs, pst, conn);
		  }
			 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			return res;
	}
	public static void main(String[] args) {
		DBAccess database=new DBAccess();
		/**ATMDetails details=new ATMDetails(1,"取钱",200,"2011-1-1");
	       if(database.addDetailsRecord(details)==-1)
	    	   System.out.println("插入失败");
	       else
	    	   System.out.println("插入 成功");*/
	   //System.out.println(database.getMaxID());
	  System.out.println(database.Count(0));
	}

}
