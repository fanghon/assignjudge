import java.util.Scanner;
public class zhengchaota_Avg {

	/**
	 * @param args
	 */
	static float avg(int n){
		if(n<1){
			return 0;
		}
		float avg;
		float sum=0;
		int i;
		for(i=1;i<=n;i++){
			   sum=sum+i;
		}
		avg=sum/n;
		return avg;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
	   
	   System.out.println("������nֵ:");
	   int n=0;
	try {
		Scanner sc = new Scanner(System.in);
		   n = sc.nextInt();
	} catch (Exception e) {
		System.out.println("�����ʽ����");
		return ;
	}
	   System.out.println(avg(n));
	}
		
}


