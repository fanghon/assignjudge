package edu.jmi.ATM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import edu.jmi.DBAccess.DBAccess;

/**��ҵ����㣺��ҵ������
���ԣ����ݴ�ȡ���󡢵�ǰ�û����󡢵�ǰ���׼�¼id��-1��ʾ��ǰ��û�н��ף���1��ʼ�ۼƣ�
�������Ҫ�ӿڷ�����
public boolean validUser(UserRecord user)    
public int queryMoney()
 ��ѯ��ǰ�û��������ʻ����
public int getMoney(int money)
 ȡǮ:��֤ҵ����򡢸����� ���أ�1 �ɹ���-1��ʾ����100�ı���������-2����ʾ����5000��-3 ���� -4 ȡǮʧ�ܣ����ݸ���ʧ�ܣ�
public int saveMoney(int money) 
 ��Ǯ ����֤ҵ����򡢸����������أ�1 �ɹ���-1��ʾ����100�ı���������-2����ʾ����10000��-4 ��Ǯʧ��
public int transferMoney(String name,int money)
 ת�ˣ�����Է��û�����ת�˽���֤ҵ������������и��������˺��ϵ������أ�1 �ɹ���-1��-1��ʾ����100�ı�����-2���Է��˻������ڣ�-3 ���㣬-4 ת��ʧ��
public ATMDetails[] getDetails()
 ��ȡ��ǰ�û��Ľ��׼�¼���ϣ����޷���null��
*/
public class ATMManager {
	private static ATMManager atm=null;
	DBAccess dba=new DBAccess();//���ݴ�ȡ����
	ATMDetails details=new ATMDetails();
	UserRecord userRecord=new UserRecord();
    UserRecord currUser=null;//��ǰ�û�����
    int currId=dba.getMaxID()+1;//��ǰ���׼�¼id��-1��ʾ��ǰ��û�н��ף���1��ʼ�ۼƣ�
	//��֤�û��������Ƿ���ȷ,���ɹ������õ�ǰ�û�; ���룺�ǿ��û���������
	
    private ATMManager(){
    	
    }
    
    public static ATMManager getIInstance(){
    	if(atm == null)
    		atm = new ATMManager();
    	return atm;
    }
    public  boolean validUser(UserRecord user) {
		boolean res = false;
		UserRecord userRecord=dba.getUserRecord(user.getUser());
		if(userRecord!=null&&userRecord.getPassword().equals(user.getPassword())
				&&userRecord.getUser().equals(user.getUser())){
		         res=true;
		         currUser=userRecord;
		}
		return res;
	}
	//��ȡ��ǰ�û�����
	public UserRecord getUser(){
		return currUser;
	}
	//��ȡ��ǰ�û�����
		public int curruserId (){
			return currId;
		}
	//��ѯ��ǰ�û��������ʻ����
	public int queryMoney(){//��ѯ���
		int res=0;
		try {
			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
			Connection conn=jdbc.getConnection();   	
		//	String sql="select * from atm where name=?";
			String sql="select * from atm where name='" + currUser.getUser()+"'";
			PreparedStatement pst=conn.prepareStatement(sql);
            //pst.setString(1, currUser.getUser());
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
			 res=rs.getInt("yuer");
			}
			jdbc.free(rs, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		//res = currUser.getYuer();    //ע����ת��ʱ������
		
		
	return res; 				
	}

		public int getMoney(int money){//ȡǮ
			int res=0;
		//	java.util.Date date=new java.util.Date();
			details=new ATMDetails(currId,"ȡǮ",money,new Date(System.currentTimeMillis()));
	     	/**details.setId(currId);
			details.setOperation("ȡǮ");
			details.setMoney(money);
			//details.setTime(date);
			 * */
			if(money%100!=0){
				return res=-1;//-1��ʾ����100�ı���
			}
			 if(money>5000){
				return res=-2;//-2:��ʾ����5000
			}
			if(money>currUser.getYuer()){
				return res=-3;//-3 :��ʾ����
			}
			else {				
			  try {
		 			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
		 			Connection conn=jdbc.getConnection();   	
		 			String sql="update atm set yuer='"+(currUser.getYuer()-money)+"' where name='"+currUser.getUser()+"'";
		 			PreparedStatement pst=conn.prepareStatement(sql);
		 		    res=pst.executeUpdate();		 		    
		 		    currUser.setYuer(currUser.getYuer()-money);//����	
		 		     dba.addDetailsRecord(details);
		 		    jdbc.free(null, pst, conn);
		 		} catch (SQLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 			res=-4;
		 	}
		}
			
			return res;		
		}
		
		/**��Ǯ ����֤ҵ����򡢸����������أ�
		  1 �ɹ���-1��ʾ����100�ı���������-2����ʾ����10000��-4 ��Ǯʧ��	
		  */	
	public int saveMoney(int money){
	     int res=0;
	     details=new ATMDetails(currId,"��Ǯ",money,new Date(System.currentTimeMillis()));
	 	if(money%100!=0){
			return res=-1;//-1��ʾ����100�ı���
		}
		else if(money>10000){
			return res=-2;//-2:��ʾ����5000
		}
		else {
	     try {
	 			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
	 			Connection conn=jdbc.getConnection();   	
	 			String sql="update atm set yuer='"+(currUser.getYuer()+money)+"' where name='"+currUser.getUser()+"'";
	 			PreparedStatement pst=conn.prepareStatement(sql);
	 		    res=pst.executeUpdate();
	 		   currUser.setYuer(currUser.getYuer() +money);//����
	 		    dba.addDetailsRecord(details);
	 		    jdbc.free(null, pst, conn);
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 			res=-4;
	 	 }
		}
	    return res;	    		 
	}
	/**
	     ת�ˣ�����Է��û�����ת�˽���֤ҵ������������и��������˺��ϵ���
	     ���أ�1 �ɹ���-1��ʾ����100�ı�����-2���Է��˻������ڣ�-3 ���㣬-4 ת��ʧ��
	 * @throws SQLException 
	 */
	public int transferMoney(String desname,int transmoney) {//ת��
		int res=0;
		int yuer = 0;	
		 details=new ATMDetails(currId,"ת��", transmoney,new Date(System.currentTimeMillis()));
		ATMManager atm =ATMManager.getIInstance();
		if(transmoney%100!=0){
			return res=-1;//-1��ʾ����100�ı���
		 }
		else if(transmoney>currUser.getYuer()){
			return res=-3;//-3��ʾ����
		} else {
			String sql="select * from atm where name ='" + desname + "'";
			if(!atm.isexsits(sql)){
						return res=-2;//-2��ʾ�˺Ų�����
					}			
					else{
						Connection conn=null;
						ResultSet rs=null;
						try {
							JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
							conn=jdbc.getConnection();   
							 conn.setAutoCommit(false);
					          sql="update atm set yuer='"+(currUser.getYuer()-transmoney)+"'where name='"+currUser.getUser()+"'";
					         PreparedStatement pst=conn.prepareStatement(sql);
				 		      res=pst.executeUpdate();
				 		      currUser.setYuer(currUser.getYuer()+transmoney);//���µ�ǰ�˻����
					         sql="select * from atm where name='"+desname+"'";//��ȡת���˺ŵ���Ϣ
							 pst=conn.prepareStatement(sql);
							 rs=pst.executeQuery();
							 while(rs.next()){
							 yuer=rs.getInt("yuer");		 
							}
								 sql="update atm set yuer='"+(yuer+transmoney)+"' where name='"+desname+"'";
								 userRecord.setYuer(yuer+transmoney);
								  pst=conn.prepareStatement(sql);
						 		  res=pst.executeUpdate();
							 conn.commit();
							  dba.addDetailsRecord(details);
							jdbc.free(rs, pst, conn);
						} catch (SQLException e) {
							res=-4;
							e.printStackTrace();
							try {
								conn.rollback();//�ع�����
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						
						}
					}
		}
		return res;
	}
	

	//����һ�������ж϶Է��˺��Ƿ����
	 public boolean isexsits(String sql)  {
	        boolean res = false;
	        try {
	             JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
 			     Connection conn=jdbc.getConnection();   			    
	                PreparedStatement pst=conn.prepareStatement(sql);
	                ResultSet rs= pst.executeQuery();
	                if (rs.next()) {
	                    res = true;
	                }
	                jdbc.free(rs, pst, conn);
	            } catch (SQLException ex) {
	                System.out.println("����ʧ��" + ex.getMessage());
	          }
       return res;
}
	 
	public int  changePwd(String pwd){
		int res=0;
		try {
			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
			Connection conn=jdbc.getConnection();   	
			String sql="update atm set password='"+pwd+"' where name='"+currUser.getUser()+"'";
			PreparedStatement pst=conn.prepareStatement(sql);
		    res=pst.executeUpdate();
		    jdbc.free(null, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public static void main(String[] args) {
		DBAccess dba=new DBAccess();
		ATMDetails[] details=dba.getDetails(0);
		for(int i=0;i<details.length;i++)
		{
			System.out.println(details[i].getId()+"\t"+details[i].getOperation()+"\t"+details[i].getMoney()+"\t"+details[i].getTime());
		}
		
	}

}

