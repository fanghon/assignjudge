package customer.jmi.edu;

import java.util.ArrayList;

public class CustomerManager {
	//�ͻ��ļ���
    ArrayList clist = new ArrayList();
    
	//����ͻ��ķ���,���ͻ�������뵽�ͻ��б��С�
    //���������customer,����ֵ: ��
 public    void add(Customer cust){
    	clist.add(cust); //���ͻ�������뵽�ͻ��б���
    }
    //�������֤�Ų�ѯ���������пͻ��ķ���
    // �������֤���룬�ڿͻ��б��в�ѯ��������Ӧ�ͻ�����
    //���룺���֤�ţ����أ��ͻ���������鲻��������null
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
