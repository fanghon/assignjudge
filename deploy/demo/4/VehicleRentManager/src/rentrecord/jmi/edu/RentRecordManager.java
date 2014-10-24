package rentrecord.jmi.edu;

import java.util.ArrayList;

import vehicle.jmi.edu.Car;
import vehicle.jmi.edu.Vehicle;
import customer.jmi.edu.Customer;

public class RentRecordManager {
	//�����¼�ļ���
	 ArrayList rlist = new ArrayList();	
	
	
	//��Ӽ�¼�ķ���������ͻ�����ͳ�������
	   //���ܣ�����һ���⳵��¼�������¼�б���
	   //����������⳵�������ͻ������������
	 public void add(Customer cust,Vehicle ve){
		 //����һ�������¼
		RentRecord rr = new RentRecord(cust,ve);
		rlist.add(rr);
		   
	  }
	 //����һ�������¼
	 public void add(RentRecord rr){
		 
		rlist.add(rr);
		   
	 }
	
	  //���ݳ��Ż�ȡ���⳵����Ӧ��¼�ķ���
	 //���ܣ���ѯ���ţ����������Ӧ������¼,
	 //���복�Ų�������������ز鵽�����⳵���������鲻������null
	  public  RentRecord   query(String carno){
		  RentRecord v = null;
		 for(int i=0;i<rlist.size();i++){
			 RentRecord rr=(RentRecord)rlist.get(i) ;
			 if(rr.getVe().getPaihao().equals(carno)
					 && rr.getStatus()==1){
				 return  rr;
			 } 
			 
		 } //for
		  
		 return v;
	  }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RentRecordManager  rrm = new RentRecordManager();
	     Customer cust = new Customer("fh","320121","15850675602");
	     Car car = new Car("��AC8888",1,800000,2000,0);
         rrm.add(cust, car);
         RentRecord rr = rrm.query("��AC8888");
         rr.getVe().print();
	}

}