package vehicle.jmi.edu;

public class Truck extends Vehicle
{
  float dunwei ; //��λ
  float licheng ; //���
  
  public Truck(String paihao,int type,float carprice,float rentprice,int state){
	
	super(paihao, type, carprice, rentprice, state);
		// TODO Auto-generated constructor stub
	type = 3; 
  }
    //�����ĳ��ⵥ�ۣ�Ԫ/����ÿ��λ����* ��ʻ���*��λ��
public	float chuzumoney(){  //��д�˸���ļ��㷽��
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
