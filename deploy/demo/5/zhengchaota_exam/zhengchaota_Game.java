import java.util.Scanner;


public class zhengchaota_Game {

	/**
	 * @param args
	 */
	static void mean(){			//�˵�
		System.out.println("1 ��ʼ��Ϸ");
		System.out.println("2 �˳�");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String select;
		while(true){
			mean();
			System.out.println("��ѡ��");
			select=sc.next();
			if(select.equals("1")){
				System.out.println("��ʼ��Ϸ");
			}else if(select.equals("2")){
				System.out.println("�����˳�");
				System.exit(0);
			}else{
				System.out.println("����������������");
			}
		}
	}

}
