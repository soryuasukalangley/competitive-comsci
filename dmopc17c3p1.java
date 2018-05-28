import java.util.Scanner;

public class dmopc17c3p1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int min=Integer.MAX_VALUE;
		for(int i=0;i<a;i++) {
			int b=sc.nextInt();
			if(b<min)
				min=b;
		}
		System.out.println(min);

	}

}
