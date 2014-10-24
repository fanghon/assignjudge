package customer.jmi.edu;

import java.util.ArrayList;

public class CustomerManager {
	//客户的集合
    ArrayList clist = new ArrayList();
    
	//加入客户的方法,将客户对象加入到客户列表中。
    //输入参数：customer,返回值: 无
 public    void add(Customer cust){
    	clist.add(cust); //将客户对象加入到客户列表中
    }
    //根据身份证号查询并返回已有客户的方法
    // 根据身份证号码，在客户列表中查询，返回相应客户对象
    //输入：身份证号，返回：客户对象，如果查不到，返回null
  public   Customer  query(String id){
    	Customer cust = null;
    	for(int i=0;i<clist.size();i++){
    		Customer c1 =  (Customer) clist.get(i);
    		if(c1.getId().equals(id)){
    			return c1;
    		}
    		
    	}
    	return cust;
    }
    
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   CustomerManager cm = new CustomerManager();
       Customer cust1 = new Customer("fh","320121","15850675602");
       cm.add(cust1);
       Customer cust2 = cm.query("320121");
       cust2.print();
	
	
	}

}
