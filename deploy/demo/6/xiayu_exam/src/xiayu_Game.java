import java.util.Scanner;


public class xiayu_Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xiayu_Game g=new xiayu_Game();
		g.show();
	}
	void show(){
		System.out.println("1����ʼ��Ϸ  2���˳�");
		check();
	}
	int check(){
		Scanner sc=new Scanner(System.in);
		int input = 0;
		if(sc.hasNext())
			try{
				input=sc.nextInt();
			}
		catch(Exception e){
			System.out.println("�����������������");
			show();
			return 0;
		}
		switch(input){
		case 1:show();return 0;
		case 2:return 0;
		default:System.out.println("�����������������");
		show();
		return 0;
		}
	}
}
