package vehicle.jmi.edu;

public class Car extends Vehicle {
	int rentday ; //�⳵ʱ��(��)
	
	public Car(String paihao, int type, float carprice, float rentprice, int state) {
		super(paihao, type, carprice, rentprice, state);
		type = 1;  //ȷ��Ϊ�γ�������Ϊ1
		// TODO Auto-generated constructor stub
	}


	 //������������ֵ�����
	//�γ����⳵����*�⳵���ۣ�Ԫ/�죩
 public	float chuzumoney(){  //��д�˸���ļ��㷽��
		return rentday*rentprice;	
		  
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Car car = new Car("��AC8888",1,800000,2000,0);
      car.print();
      //���Գ�����
      car.setRentday(7);
      System.out.println("������:"+car.chuzumoney());
	}

	public int getRentday() {
		return rentday;
	}

	public void setRentday(int rentday) {
		this.rentday = rentday;
	}

}
