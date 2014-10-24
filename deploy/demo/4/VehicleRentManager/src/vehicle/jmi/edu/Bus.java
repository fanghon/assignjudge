package vehicle.jmi.edu;

public class Bus extends Vehicle {
	int renthour ; //租车时间(天)
	int seatnum ; //座位数
	
	
	Bus(String paihao, int type, float carprice, float rentprice, int state) {
		super(paihao, type, carprice, rentprice, state);
		type = 2 ;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	//客车的出租单价（元/每小时每座位）*座位数*租车小时数
	public float chuzumoney(){  //重写了父类的计算方法
	  return rentprice*renthour*seatnum;	
		  
	 }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Bus bus = new Bus("苏A18888",2,1200000,20,0);
	   bus.print();
	   
	   bus.setSeatnum(40); //座位数
	   bus.setRenthour(8); //出租小时数
	   System.out.println("出租金额:"+bus.chuzumoney()); //期望6400
	
	}

	public int getRenthour() {
		return renthour;
	}

	public void setRenthour(int renthour) {
		this.renthour = renthour;
	}

	public int getSeatnum() {
		return seatnum;
	}

	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}

}
