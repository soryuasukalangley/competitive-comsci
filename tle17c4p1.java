import java.util.Scanner;

public class tle17c4p1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		double b=sc.nextInt();
		double c=sc.nextInt();
		boolean chk=false;
		for(int i=0;i<=a;i++) {
			double x=((i+b)/c)*100;
			if(x>=59.5) {
				System.out.println(i);
				chk=true;
				break;
			}
		}
		if(!chk)
			System.out.println("have mercy snew");
	}

}
