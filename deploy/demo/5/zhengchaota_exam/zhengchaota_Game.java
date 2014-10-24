import java.util.Scanner;


public class zhengchaota_Game {

	/**
	 * @param args
	 */
	static void mean(){			//菜单
		System.out.println("1 开始游戏");
		System.out.println("2 退出");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String select;
		while(true){
			mean();
			System.out.println("请选择：");
			select=sc.next();
			if(select.equals("1")){
				System.out.println("开始游戏");
			}else if(select.equals("2")){
				System.out.println("程序退出");
				System.exit(0);
			}else{
				System.out.println("输入错误，请从新输入");
			}
		}
	}

}
