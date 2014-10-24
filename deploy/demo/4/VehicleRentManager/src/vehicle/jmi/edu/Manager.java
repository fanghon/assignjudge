package vehicle.jmi.edu;
import java.util.ArrayList;

public class Manager {
    ArrayList carlist = new ArrayList();
    
    public Manager(){
    	initcar();
    	inittruck();
    	initbus();
    }
    
	//根据车类型获取空闲车辆的方法
	//输入：车型 ；输出：该车型空闲车辆，如果没有，返回null
	public Vehicle query(int type){
	  Vehicle ve = null;
	  for(int i=0;i<carlist.size();i++){
		  ve = (Vehicle)carlist.get(i);
		  if(ve.getType()==type && ve.getState()==1){
			  return ve;
		  }
	  }
	   return ve;		
		
	}
	//初始化轿车9辆
	void initcar(){
	//车型1，轿车：15万,1800元/天,初始状态为空闲1
	 for(int i=1;i<=9;i++) {   	
	  Car car = new Car("苏轿A000"+i,1,150000,1800,1);
	  carlist.add(car);    
	 }	
	}
	//初始化货车9辆
	void inittruck(){
	//苏货A0001,初始状态为空闲,18万（10吨） 0.5元/每公里吨位数	
		 for(int i=1;i<=9;i++) {   	
			  Truck truck = new Truck("苏货A000"+i,3,180000,0.5f,1);
			  truck.setDunwei(10);
			  carlist.add(truck);    
			 }			
	}

	//初始化客车9辆
	void initbus(){
	//苏客A0001,初始状态为空闲,20万（20坐） 10元/每小时
		for(int i=1;i<=9;i++) {   	
			  Bus bus = new Bus("苏客A000"+i,2,200000,10,1);
			  bus.setSeatnum(20);
			  carlist.add(bus);    
			 }			
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
