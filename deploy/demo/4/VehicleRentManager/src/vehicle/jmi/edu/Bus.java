package vehicle.jmi.edu;

public class Bus extends Vehicle {
	int renthour ; //�⳵ʱ��(��)
	int seatnum ; //��λ��
	
	
	Bus(String paihao, int type, float carprice, float rentprice, int state) {
		super(paihao, type, carprice, rentprice, state);
		type = 2 ;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	//�ͳ��ĳ��ⵥ�ۣ�Ԫ/ÿСʱÿ��λ��*��λ��*�⳵Сʱ��
	public float chuzumoney(){  //��д�˸���ļ��㷽��
	  return rentprice*renthour*seatnum;	
		  
	 }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Bus bus = new Bus("��A18888",2,1200000,20,0);
	   bus.print();
	   
	   bus.setSeatnum(40); //��λ��
	   bus.setRenthour(8); //����Сʱ��
	   System.out.println("������:"+bus.chuzumoney()); //����6400
	
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
