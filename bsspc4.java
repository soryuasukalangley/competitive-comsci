import java.util.Scanner;

public class bsspc4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int best=0;
		int[]ItIsKevin=new int[a+1];
		for(int i=1;i<=a;i++) {
			int x=sc.nextInt();
			ItIsKevin[i]=ItIsKevin[i-1]+x;
		}
		for(int i=1;i<=a;i++) {
			for(int j=0;j<i;j++) {
				if(best<ItIsKevin[i]-ItIsKevin[j])
					best=ItIsKevin[i]-ItIsKevin[j];
			}
		}
		System.out.println(best);

	}

}
