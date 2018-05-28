import java.util.Scanner;

public class dmopc17c2p0 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double a=sc.nextInt();
		double b=sc.nextInt();
		double c=sc.nextInt();
		double d=sc.nextInt();
		double e=sc.nextInt();
		double f=sc.nextInt();
		double g=sc.nextInt();
		if(Math.sqrt(Math.pow(f-b, 2)+Math.pow(e-a, 2))<=g||Math.sqrt(Math.pow(f-d, 2)+Math.pow(e-c, 2))<=g)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
