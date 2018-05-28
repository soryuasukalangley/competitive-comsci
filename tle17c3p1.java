import java.util.Scanner;

public class tle17c3p1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int max=0;
		for(int i=0;i<c;i++) {
			int d=sc.nextInt();
			int e=sc.nextInt();
			if(max<Math.abs(d-a)+Math.abs(e-b)) {
				max=Math.abs(d-a)+Math.abs(e-b);
			}
		}
		System.out.println(max*max*2);

	}

}
