package vehicle.jmi.edu;
import java.util.ArrayList;

public class Manager {
    ArrayList carlist = new ArrayList();
    
    public Manager(){
    	initcar();
    	inittruck();
    	initbus();
    }
    
	//���ݳ����ͻ�ȡ���г����ķ���
	//���룺���� ��������ó��Ϳ��г��������û�У�����null
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
	//��ʼ���γ�9��
	void initcar(){
	//����1���γ���15��,1800Ԫ/��,��ʼ״̬Ϊ����1
	 for(int i=1;i<=9;i++) {   	
	  Car car = new Car("�ս�A000"+i,1,150000,1800,1);
	  carlist.add(car);    
	 }	
	}
	//��ʼ������9��
	void inittruck(){
	//�ջ�A0001,��ʼ״̬Ϊ����,18��10�֣� 0.5Ԫ/ÿ�����λ��	
		 for(int i=1;i<=9;i++) {   	
			  Truck truck = new Truck("�ջ�A000"+i,3,180000,0.5f,1);
			  truck.setDunwei(10);
			  carlist.add(truck);    
			 }			
	}

	//��ʼ���ͳ�9��
	void initbus(){
	//�տ�A0001,��ʼ״̬Ϊ����,20��20���� 10Ԫ/ÿСʱ
		for(int i=1;i<=9;i++) {   	
			  Bus bus = new Bus("�տ�A000"+i,2,200000,10,1);
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
