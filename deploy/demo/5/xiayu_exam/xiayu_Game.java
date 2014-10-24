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
		System.out.println("1、开始游戏  2、退出");
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
			System.out.println("输入错误，请重新输入");
			show();
			return 0;
		}
		switch(input){
		case 1:show();return 0;
		case 2:return 0;
		default:System.out.println("输入错误，请重新输入");
		show();
		return 0;
		}
	}
}
