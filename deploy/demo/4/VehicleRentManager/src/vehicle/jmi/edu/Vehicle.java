package vehicle.jmi.edu;

public class Vehicle {
  String paihao  ;//���ƺ�
  int type;//������,1 �γ� 2 �ͳ� 3 ����
  float carprice; //�����۸�
  float rentprice;//���ⵥ��
  int state ;  //״̬ -1ͣ��/0����/1����
	
  Vehicle(String paihao,int type,float carprice,float rentprice,int state){
	this.paihao = paihao;
	this.type = type;
	this.carprice = carprice;
	this.rentprice = rentprice;
	this.state = state;	  
	  
  }
  //������������ֵ�����,Ĭ���ǳ��ⵥ��
 public  float chuzumoney(){
	return rentprice;	
	  
  }
  
  public void print(){
	System.out.println("---������Ϣ---"); 
	System.out.println("���ƺ�:"+paihao);
	System.out.println("������:"+type);
	System.out.println("�����۸�:"+carprice);
	System.out.println("���ⵥ��:"+rentprice);
	System.out.println("״̬:"+state);
	
  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Vehicle car = new Vehicle("AC8888",1,800000,2000,1);
	   car.print(); 
	   System.out.println("�����"+car.chuzumoney());
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
