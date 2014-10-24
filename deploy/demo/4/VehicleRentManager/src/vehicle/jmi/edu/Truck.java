package vehicle.jmi.edu;

public class Truck extends Vehicle
{
  float dunwei ; //吨位
  float licheng ; //里程
  
  public Truck(String paihao,int type,float carprice,float rentprice,int state){
	
	super(paihao, type, carprice, rentprice, state);
		// TODO Auto-generated constructor stub
	type = 3; 
  }
    //货车的出租单价（元/公里每吨位数）* 行驶里程*吨位数
public	float chuzumoney(){  //重写了父类的计算方法
		return rentprice*licheng*dunwei;	
		  
	 }
  
  /**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
public float getDunwei()
{
	return dunwei;
}
public void setDunwei(float dunwei)
{
	this.dunwei = dunwei;
}
public float getLicheng()
{
	return licheng;
}
public void setLicheng(float licheng)
{
	this.licheng = licheng;
}

}
