import java.util.Scanner;

public class dmopc17c2p1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		long co=0;
		for(int i=0;i<a;i++) {
			long b=sc.nextLong();
			long c=sc.nextLong();
			if(c>0L)
				co=co+b;
		}
		System.out.println(co);

	}

}
