import java.util.Scanner;
/**
 *  输入两个整数相加求和：
 *  输入 举例:  1  2
 *  输出举例:  a+b is 3
 * @author zq
 *
 */

public class ABAdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int a = 0;
	  int b = 0;
      System.out.println("请输入a b两个整数：");
      Scanner sc = new Scanner(System.in);
      a = sc.nextInt();
      if(sc.hasNext())
    	b = sc.nextInt();
      System.out.println("a+b is :"+(a+b));
	}

}
