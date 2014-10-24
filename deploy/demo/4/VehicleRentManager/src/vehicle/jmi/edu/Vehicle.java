package vehicle.jmi.edu;

public class Vehicle {
  String paihao  ;//车牌号
  int type;//车类型,1 轿车 2 客车 3 货车
  float carprice; //购车价格
  float rentprice;//出租单价
  int state ;  //状态 -1停用/0出租/1空闲
	
  Vehicle(String paihao,int type,float carprice,float rentprice,int state){
	this.paihao = paihao;
	this.type = type;
	this.carprice = carprice;
	this.rentprice = rentprice;
	this.state = state;	  
	  
  }
  //计算出租金额，返回值：租金,默认是出租单价
 public  float chuzumoney(){
	return rentprice;	
	  
  }
  
  public void print(){
	System.out.println("---车辆信息---"); 
	System.out.println("车牌号:"+paihao);
	System.out.println("车类型:"+type);
	System.out.println("购车价格:"+carprice);
	System.out.println("出租单价:"+rentprice);
	System.out.println("状态:"+state);
	
  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Vehicle car = new Vehicle("AC8888",1,800000,2000,1);
	   car.print(); 
	   System.out.println("出租金额："+car.chuzumoney());
	}

	public String getPaihao() {
		return paihao;
	}

	public void setPaihao(String paihao) {
		this.paihao = paihao;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public float getCarprice() {
		return carprice;
	}

	public void setCarprice(float carprice) {
		this.carprice = carprice;
	}

	public float getRentprice() {
		return rentprice;
	}

	public void setRentprice(float rentprice) {
		this.rentprice = rentprice;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
