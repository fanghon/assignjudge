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
���ݴ�ȡ�ࣺ�������ݿ�����ӡ��رգ����ݵĻ�ȡ�����¡����
*/
public class DBAccess {  
	
	
	public UserRecord getUserRecord(String name){
		/**
		 *    �����û����ֻ�ȡ�û���¼�������򷵻�null
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
		/** ����ָ���û�����Ϣ����������Ҳ���������룩
                                 �ɹ����� 1��ʧ�ܷ���-1�� */
		int res=0;
		return res;
	}
	public int addDetailsRecord(ATMDetails ad){
		/**  ���һ�����ײ�����¼�����ɹ����ز�����ID�ţ�ʧ�ܷ���-1
                                    ע��һ�ε�¼��β�����ID������ͬ�ġ������ad�����е�id�������0����ʹ�ø�
             id��Ӽ�¼��������Ҫ��ѯ���еĵ�ǰ���id�ţ���1����Ϊ���β�����id��д���¼��ͬʱ����
                                     �����µ�id�ţ�ҵ�����Ӧ������Чid�����ڵ�ǰ����id���С�
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
		/** ����id�Ż�ȡ������ϸ��¼���ϣ������򷵻�null��
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
		//��ѯ���׼�¼���е����ID,�ձ�id����0����ȡ���id��Ŀ���ǣ������ظ�
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
	//��ȡ���׼�¼���ķ���
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
		/**ATMDetails details=new ATMDetails(1,"ȡǮ",200,"2011-1-1");
	       if(database.addDetailsRecord(details)==-1)
	    	   System.out.println("����ʧ��");
	       else
	    	   System.out.println("���� �ɹ�");*/
	   //System.out.println(database.getMaxID());
	  System.out.println(database.Count(0));
	}

}
