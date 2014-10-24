package rentrecord.jmi.edu;

import java.util.ArrayList;

import vehicle.jmi.edu.Car;
import vehicle.jmi.edu.Vehicle;
import customer.jmi.edu.Customer;

public class RentRecordManager {
	//出租记录的集合
	 ArrayList rlist = new ArrayList();	
	
	
	//添加记录的方法（输入客户对象和车辆对象）
	   //功能：生成一条租车记录，加入记录列表集合
	   //输入参数：租车车辆及客户对象，输出：无
	 public void add(Customer cust,Vehicle ve){
		 //生成一个出租记录
		RentRecord rr = new RentRecord(cust,ve);
		rlist.add(rr);
		   
	  }
	 //加入一条出租记录
	 public void add(RentRecord rr){
		 
		rlist.add(rr);
		   
	 }
	
	  //根据车号获取在租车辆对应记录的方法
	 //功能：查询车号，返回在租对应车辆记录,
	 //输入车号参数，输出：返回查到的在租车辆对象，若查不到返回null
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
	     Car car = new Car("苏AC8888",1,800000,2000,0);
         rrm.add(cust, car);
         RentRecord rr = rrm.query("苏AC8888");
         rr.getVe().print();
	}

}