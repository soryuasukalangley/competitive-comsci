import java.util.Scanner;

public class gcf {
	
	public static long gcf(long a,long b) {
		if(b==0)
			return a;
		return gcf(b, a%b);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		long b=sc.nextLong();
		System.out.println(gcf(a,b));

	}

}
