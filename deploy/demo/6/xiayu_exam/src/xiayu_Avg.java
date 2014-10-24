
public class xiayu_Avg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xiayu_Avg a=new xiayu_Avg();
		System.out.println(a.avg(Integer.parseInt(args[0])));
	}
	float avg(int n){
		if (n<1)
		return 0;
		return ((float)((n+1)*(n/2))/(float)n);
	}

}
