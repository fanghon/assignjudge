package vehicle.jmi.edu;

public class Car extends Vehicle {
	int rentday ; //租车时间(天)
	
	public Car(String paihao, int type, float carprice, float rentprice, int state) {
		super(paihao, type, carprice, rentprice, state);
		type = 1;  //确定为轿车，类型为1
		// TODO Auto-generated constructor stub
	}


	 //计算出租金额，返回值：租金
	//轿车：租车天数*租车单价（元/天）
 public	float chuzumoney(){  //重写了父类的计算方法
		return rentday*rentprice;	
		  
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Car car = new Car("苏AC8888",1,800000,2000,0);
      car.print();
      //测试出租金额
      car.setRentday(7);
      System.out.println("出租金额:"+car.chuzumoney());
	}

	public int getRentday() {
		return rentday;
	}

	public void setRentday(int rentday) {
		this.rentday = rentday;
	}

}
