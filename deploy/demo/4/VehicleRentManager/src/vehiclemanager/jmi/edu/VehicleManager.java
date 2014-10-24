package vehiclemanager.jmi.edu;

import java.util.Scanner;
import java.util.Date;

import rentrecord.jmi.edu.RentRecord;
import rentrecord.jmi.edu.RentRecordManager;
import customer.jmi.edu.Customer;
import customer.jmi.edu.CustomerManager;
import vehicle.jmi.edu.*;
/**
 * �����ࣺ�����û����潻����ʵ�����ؿ�ܣ���ͨ�����������ͻ��������ⵥ�����ʵ�ֳ��⼰����ҵ�����̣�
 * ���Ը�����Ӧ������������ĳ�Ա������
 * 
 * 2013.11.22
 * ��ɳ���
 * ���ԣ�
 * 1 ���ֳ��͵ĳ��⡢������̻�������
 * 2 ���ֳ��͵�����������
 * 
 * ��ѵ��
 * 1 ��һ��ϸ�����⡢�����㷨��һЩ�ѵ㣨��ʼ����ʱ����㣩��������
 * 2 ����ѧ�������������Ŀ�Ѷ�
 * @author Administrator
 *
 */
public class VehicleManager {
	CustomerManager cm   ;   //�ͻ�����
	RentRecordManager rm;   //�����¼����
	vehicle.jmi.edu.Manager   vm; //��������
	
	public VehicleManager(){
		this.cm = new CustomerManager();
		this.rm = new RentRecordManager();
		this.vm = new vehicle.jmi.edu.Manager();
	}
	//��ʾ�˵�,���ܣ���ʾ���˵�
	//���롢����ֵΪ��
	void displayMenu(){ //�ع�����
		System.out.println("1 �������");
		System.out.println("2 �������");
		System.out.println("3 �˳�����");		
	}
	/** ������� 
	 * 1 ������ʾ����ѡ���ͣ�1 �γ� 2 �ͳ� 3 ������
	 * 
	 * 
	 * 
	 */
	void vehicleManage(){
	  //1 ��ʾ����
	 System.out.println("��ѡ���ͣ�1 �γ� 2 �ͳ� 3 ����");	
	 //2 ��ȡ����
	 Scanner  in = new Scanner(System.in);
	 int sel = in.nextInt();
	 //3���ݳ��ͣ���ѯ���޿��г���
	 vehicle.jmi.edu.Vehicle ve = vm.query(sel);
	 if(ve!=null){
	   //4 ����һ���� 	 
	   ve.setState(0);	 //������״̬����Ϊ����
	   //5 ��ʾ������ͻ����֤��	 
	   System.out.println("���������֤�ţ�");	
	   in.nextLine();
	   String  id = in.nextLine();
	   //6 �������֤�Ų�ѯ�ͻ�����
	   Customer   cust = cm.query(id);
	   //7 ��ȡ�ͻ���Ϣ
	   if(cust==null){
		 // 7.1 ��ʾ��������Ϣ����������ϵ�绰��   
		System.out.println("������������"); 
		String name = in.nextLine();
		System.out.println("������绰��"); 
		String tel = in.nextLine();
		//7.2 ����ͻ���Ϣ
		cust = new Customer(name,id,tel);
		cm.add(cust);
	   }
	   //8 ϵͳ��ʾ�⳵��¼��Ϣ
//�����š����͡��ͻ����������֤�š�Ԥ��������۵�1%֧�������⳵��ʼʱ�䣩	   
	   System.out.println("����:"+ve.getPaihao()+"����:"+ve.getType()+"�ͻ�����:"+cust.getName());
	   //��ʾ���Ƿ�ȷ���⳵��Y/N)��
	   System.out.println("�Ƿ�ȷ���⳵��Y/N)");
	   String str=in.nextLine();
	   if(str.equalsIgnoreCase("Y")){
		  RentRecord rr = new RentRecord(cust,ve);
		   // �޸ĳ����¼״̬
		  rr.setStatus(1);//״̬Ϊ�ڳ���1
		  Date bdate = new Date();
		  rr.setBegintime(bdate);  //���ÿ�ʼʱ��
		  rr.setYufukuan(ve.getCarprice()*0.01f); //����Ԥ����
		  //��������¼
		  rm.add(rr);
		  System.out.println("�⳵�ɹ�");
	   }else{  //���⳵
		 System.out.println("�⳵ȡ��");  
	   }
	 }else{
		System.out.println("û�г��ɹ�����"); 
	 }
	 
	}
	//����
	void tuizhu(){
		//1 �����복�ƺ�
		System.out.println("�����복�ƺ�");
		 //2 ��ȡ���복�ƺ�
		 Scanner  in = new Scanner(System.in);
		 String pai = in.nextLine();
		 //3 ϵͳ���ҵ���Ӧ�⳵��¼
		 RentRecord rr = rm.query(pai);
		 if(rr!=null){  //�д˳�
			if(rr.getVe().getState()!=1){ //�ڳ���
			   //3.1�ǻ���
				if(rr.getVe().getType()==3){
				//��ȡ��ʻ��̣���������
				  System.out.println("�����������ʻ��̣�");
				  float licheng = in.nextFloat();
				  in.nextLine();  //�����س���
				   Truck  tr = (Truck)(rr.getVe());
				   tr.setLicheng(licheng);		 //���ó������		  
			    }
				//3.2  ��������
				if(rr.getVe().getType()==1){ //�γ�
					Date now = new Date();
					//����ʱ���ֵ����λ����
					long cha = now.getTime()-rr.getBegintime().getTime();
					int hour =(int) cha/1000/3600;  //ת��Сʱ
					Car car = (Car)rr.getVe();
					car.setRentday(hour/24+1);  // ת������
				}
				
				if(rr.getVe().getType()==2){ //�ͳ�
					Date now = new Date();
					//����ʱ���ֵ����λ����
					long cha = now.getTime()-rr.getBegintime().getTime();
					int hour =(int) cha/1000/3600;  //ת��Сʱ
					Bus bus = (Bus)rr.getVe();
					bus.setRenthour(hour);  // ת����Сʱ
				}
				
				
				float zhujing = rr.getVe().chuzumoney();
				//3.3 ��ʾ�ͻ����������ƺš�Ӧ���ɵ����ʵ�����-Ԥ���
				System.out.println(rr.getCust().getName()+","+rr.getVe().getPaihao()+","+
				                   "�ٸ���"+(zhujing-rr.getYufukuan())    );
				//3.4 �Ƿ�ȷ�����⣨Y/N)
				System.out.println("�Ƿ�ȷ�����⣨Y/N)");
				String str = in.nextLine();
				if("Y".equalsIgnoreCase(str)){
					System.out.println("����ɹ�");
				//�޸ĳ���״̬����¼�����Ϣ����𡢽���ʱ�䡢��ʻ��̣���������
					rr.getVe().setState(1);  //����״̬����1
					rr.setRentmoney(zhujing);
					rr.setEndtime(new Date());
					//������̶��������Ϣʱ�Ѿ�����
					rr.setStatus(2);// ���ⵥ״̬��Ϊ����2
					
				}else{
					System.out.println("����ȡ��");
				}
				
			}else{ //�����ǿ��в��ڳ���
				System.out.println("�ó�δ����");
			}
			 
		 }else{ //���޴˳�
			 System.out.println("���޴˳�");
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
		//��ȡ����
		Scanner  in = new Scanner(System.in);
		int sel = in.nextInt();
		// ��������
		switch (sel) {
		case 1: vm.vehicleManage();
			    //System.out.println("�������");
		        break;
		case 2: vm.tuizhu();
			    //System.out.println("�������");
		        break;
		case 3: System.out.println("�˳�����");
		        bexit = true;
		        break;
		default : System.out.println("�����������������");
		          break;
		
		} 
		
	  }//while

	}

}
