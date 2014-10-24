package edu.jmi.ATM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import edu.jmi.DBAccess.DBAccess;

/**：业务处理层：即业务处理类
属性：数据存取对象、当前用户对象、当前交易记录id（-1表示当前还没有交易，从1开始累计）
对外的主要接口方法：
public boolean validUser(UserRecord user)    
public int queryMoney()
 查询当前用户，返回帐户余额
public int getMoney(int money)
 取钱:验证业务规则、更新余额； 返回：1 成功；-1表示不是100的倍数，返回-2，表示超过5000；-3 余额不够 -4 取钱失败（数据更新失败）
public int saveMoney(int money) 
 存钱 ：验证业务规则、更新余额；存款，返回：1 成功，-1表示不是100的倍数，返回-2，表示超过10000，-4 存钱失败
public int transferMoney(String name,int money)
 转账：输入对方用户名、转账金额，验证业务规则，在事务中更新两个账号上的余额；返回：1 成功，-1，-1表示不是100的倍数，-2，对方账户不存在，-3 余额不足，-4 转账失败
public ATMDetails[] getDetails()
 获取当前用户的交易记录集合，若无返回null。
*/
public class ATMManager {
	private static ATMManager atm=null;
	DBAccess dba=new DBAccess();//数据存取对象
	ATMDetails details=new ATMDetails();
	UserRecord userRecord=new UserRecord();
    UserRecord currUser=null;//当前用户对象
    int currId=dba.getMaxID()+1;//当前交易记录id（-1表示当前还没有交易，从1开始累计）
	//验证用户名口令是否正确,若成功会设置当前用户; 输入：非空用户名及密码
	
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
	//获取当前用户对象
	public UserRecord getUser(){
		return currUser;
	}
	//获取当前用户对象
		public int curruserId (){
			return currId;
		}
	//查询当前用户，返回帐户余额
	public int queryMoney(){//查询余额
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
    
		//res = currUser.getYuer();    //注意提款、转账时，更新
		
		
	return res; 				
	}

		public int getMoney(int money){//取钱
			int res=0;
		//	java.util.Date date=new java.util.Date();
			details=new ATMDetails(currId,"取钱",money,new Date(System.currentTimeMillis()));
	     	/**details.setId(currId);
			details.setOperation("取钱");
			details.setMoney(money);
			//details.setTime(date);
			 * */
			if(money%100!=0){
				return res=-1;//-1表示不是100的倍数
			}
			 if(money>5000){
				return res=-2;//-2:表示超过5000
			}
			if(money>currUser.getYuer()){
				return res=-3;//-3 :表示余额不够
			}
			else {				
			  try {
		 			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
		 			Connection conn=jdbc.getConnection();   	
		 			String sql="update atm set yuer='"+(currUser.getYuer()-money)+"' where name='"+currUser.getUser()+"'";
		 			PreparedStatement pst=conn.prepareStatement(sql);
		 		    res=pst.executeUpdate();		 		    
		 		    currUser.setYuer(currUser.getYuer()-money);//更新	
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
		
		/**存钱 ：验证业务规则、更新余额；存款，返回：
		  1 成功，-1表示不是100的倍数，返回-2，表示超过10000，-4 存钱失败	
		  */	
	public int saveMoney(int money){
	     int res=0;
	     details=new ATMDetails(currId,"存钱",money,new Date(System.currentTimeMillis()));
	 	if(money%100!=0){
			return res=-1;//-1表示不是100的倍数
		}
		else if(money>10000){
			return res=-2;//-2:表示超过5000
		}
		else {
	     try {
	 			JdbcUtilsSing jdbc=JdbcUtilsSing.getInstance();
	 			Connection conn=jdbc.getConnection();   	
	 			String sql="update atm set yuer='"+(currUser.getYuer()+money)+"' where name='"+currUser.getUser()+"'";
	 			PreparedStatement pst=conn.prepareStatement(sql);
	 		    res=pst.executeUpdate();
	 		   currUser.setYuer(currUser.getYuer() +money);//更新
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
	     转账：输入对方用户名、转账金额，验证业务规则，在事务中更新两个账号上的余额；
	     返回：1 成功；-1表示不是100的倍数；-2，对方账户不存在，-3 余额不足，-4 转账失败
	 * @throws SQLException 
	 */
	public int transferMoney(String desname,int transmoney) {//转账
		int res=0;
		int yuer = 0;	
		 details=new ATMDetails(currId,"转账", transmoney,new Date(System.currentTimeMillis()));
		ATMManager atm =ATMManager.getIInstance();
		if(transmoney%100!=0){
			return res=-1;//-1表示不是100的倍数
		 }
		else if(transmoney>currUser.getYuer()){
			return res=-3;//-3表示余额不足
		} else {
			String sql="select * from atm where name ='" + desname + "'";
			if(!atm.isexsits(sql)){
						return res=-2;//-2表示账号不存在
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
				 		      currUser.setYuer(currUser.getYuer()+transmoney);//更新当前账户余额
					         sql="select * from atm where name='"+desname+"'";//获取转账账号的信息
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
								conn.rollback();//回滚操作
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						
						}
					}
		}
		return res;
	}
	

	//定义一个方法判断对方账号是否存在
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
	                System.out.println("操作失败" + ex.getMessage());
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

