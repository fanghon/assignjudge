package vehiclemanager.jmi.edu;

import java.util.Scanner;
import java.util.Date;

import rentrecord.jmi.edu.RentRecord;
import rentrecord.jmi.edu.RentRecordManager;
import customer.jmi.edu.Customer;
import customer.jmi.edu.CustomerManager;
import vehicle.jmi.edu.*;
/**
 * 主控类：负责用户界面交互，实现主控框架，并通过车辆管理、客户管理、出租单管理等实现出租及退租业务流程；
 * 所以该类中应有上述管理类的成员变量。
 * 
 * 2013.11.22
 * 完成出租
 * 测试：
 * 1 三种车型的出租、退租过程基本正常
 * 2 三种车型的租金基本正常
 * 
 * 教训：
 * 1 进一步细化出租、退租算法，一些难点（初始化、时间计算）给出代码
 * 2 根据学生情况，降低项目难度
 * @author Administrator
 *
 */
public class VehicleManager {
	CustomerManager cm   ;   //客户管理
	RentRecordManager rm;   //出租记录管理
	vehicle.jmi.edu.Manager   vm; //车辆管理
	
	public VehicleManager(){
		this.cm = new CustomerManager();
		this.rm = new RentRecordManager();
		this.vm = new vehicle.jmi.edu.Manager();
	}
	//显示菜单,功能：显示主菜单
	//输入、返回值为空
	void displayMenu(){ //重构代码
		System.out.println("1 出租管理");
		System.out.println("2 退租管理");
		System.out.println("3 退出程序");		
	}
	/** 出租管理 
	 * 1 程序提示“请选择车型：1 轿车 2 客车 3 货车”
	 * 
	 * 
	 * 
	 */
	void vehicleManage(){
	  //1 显示车型
	 System.out.println("请选择车型：1 轿车 2 客车 3 货车");	
	 //2 读取输入
	 Scanner  in = new Scanner(System.in);
	 int sel = in.nextInt();
	 //3根据车型，查询有无空闲车辆
	 vehicle.jmi.edu.Vehicle ve = vm.query(sel);
	 if(ve!=null){
	   //4 分配一辆车 	 
	   ve.setState(0);	 //将车辆状态设置为出租
	   //5 提示并读入客户身份证号	 
	   System.out.println("请输入身份证号：");	
	   in.nextLine();
	   String  id = in.nextLine();
	   //6 根据身份证号查询客户资料
	   Customer   cust = cm.query(id);
	   //7 获取客户信息
	   if(cust==null){
		 // 7.1 提示并读入信息（姓名、联系电话）   
		System.out.println("请输入姓名："); 
		String name = in.nextLine();
		System.out.println("请输入电话："); 
		String tel = in.nextLine();
		//7.2 保存客户信息
		cust = new Customer(name,id,tel);
		cm.add(cust);
	   }
	   //8 系统显示租车记录信息
//（车号、车型、客户姓名、身份证号、预付款（按车价的1%支付）、租车开始时间）	   
	   System.out.println("车号:"+ve.getPaihao()+"车型:"+ve.getType()+"客户姓名:"+cust.getName());
	   //提示“是否确认租车（Y/N)”
	   System.out.println("是否确认租车（Y/N)");
	   String str=in.nextLine();
	   if(str.equalsIgnoreCase("Y")){
		  RentRecord rr = new RentRecord(cust,ve);
		   // 修改出租记录状态
		  rr.setStatus(1);//状态为在出租1
		  Date bdate = new Date();
		  rr.setBegintime(bdate);  //设置开始时间
		  rr.setYufukuan(ve.getCarprice()*0.01f); //设置预付款
		  //加入出租记录
		  rm.add(rr);
		  System.out.println("租车成功");
	   }else{  //不租车
		 System.out.println("租车取消");  
	   }
	 }else{
		System.out.println("没有车可供出租"); 
	 }
	 
	}
	//退租
	void tuizhu(){
		//1 请输入车牌号
		System.out.println("请输入车牌号");
		 //2 读取输入车牌号
		 Scanner  in = new Scanner(System.in);
		 String pai = in.nextLine();
		 //3 系统查找到相应租车记录
		 RentRecord rr = rm.query(pai);
		 if(rr!=null){  //有此车
			if(rr.getVe().getState()!=1){ //在出租
			   //3.1是货车
				if(rr.getVe().getType()==3){
				//读取行驶里程，计算出租金
				  System.out.println("请输入货车行驶里程：");
				  float licheng = in.nextFloat();
				  in.nextLine();  //读掉回车符
				   Truck  tr = (Truck)(rr.getVe());
				   tr.setLicheng(licheng);		 //设置车辆里程		  
			    }
				//3.2  计算出租金
				if(rr.getVe().getType()==1){ //轿车
					Date now = new Date();
					//计算时间差值，单位毫秒
					long cha = now.getTime()-rr.getBegintime().getTime();
					int hour =(int) cha/1000/3600;  //转成小时
					Car car = (Car)rr.getVe();
					car.setRentday(hour/24+1);  // 转换成天
				}
				
				if(rr.getVe().getType()==2){ //客车
					Date now = new Date();
					//计算时间差值，单位毫秒
					long cha = now.getTime()-rr.getBegintime().getTime();
					int hour =(int) cha/1000/3600;  //转成小时
					Bus bus = (Bus)rr.getVe();
					bus.setRenthour(hour);  // 转换成小时
				}
				
				
				float zhujing = rr.getVe().chuzumoney();
				//3.3 显示客户姓名、车牌号、应缴纳的租金（实际租金-预付款）
				System.out.println(rr.getCust().getName()+","+rr.getVe().getPaihao()+","+
				                   "再付："+(zhujing-rr.getYufukuan())    );
				//3.4 是否确认退租（Y/N)
				System.out.println("是否确认退租（Y/N)");
				String str = in.nextLine();
				if("Y".equalsIgnoreCase(str)){
					System.out.println("退租成功");
				//修改车辆状态，记录相关信息（租金、结束时间、行驶里程（货车））
					rr.getVe().setState(1);  //车辆状态空闲1
					rr.setRentmoney(zhujing);
					rr.setEndtime(new Date());
					//货车里程读入里程信息时已经设置
					rr.setStatus(2);// 出租单状态设为退租2
					
				}else{
					System.out.println("退租取消");
				}
				
			}else{ //车辆是空闲不在出租
				System.out.println("该车未出租");
			}
			 
		 }else{ //查无此车
			 System.out.println("查无此车");
		 }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  boolean bexit = false;
	  VehicleManager  vm = new VehicleManager();
	  
	  while(!bexit){  
	
		vm.displayMenu();  
		//读取输入
		Scanner  in = new Scanner(System.in);
		int sel = in.nextInt();
		// 处理输入
		switch (sel) {
		case 1: vm.vehicleManage();
			    //System.out.println("出租管理");
		        break;
		case 2: vm.tuizhu();
			    //System.out.println("退租管理");
		        break;
		case 3: System.out.println("退出程序");
		        bexit = true;
		        break;
		default : System.out.println("输入错误，请重新输入");
		          break;
		
		} 
		
	  }//while

	}

}
