import java.util.Scanner;

public class dmopc16c1p3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		double[]price=new double[a+1];
		for(int i=1;i<=a;i++)
			price[i]=sc.nextInt();
		double[]co=new double[a+1];
		co[1]=price[1];
		if(a>=2)
			co[2]=Math.min(price[1], price[2])*0.5+Math.max(price[1], price[2]);
		if(a>=3)
			co[3]=Math.min(price[1]+price[2]+price[3]-Math.min(Math.min(price[1], price[2]), price[3]),price[1]+price[2]+price[3]-Math.min(price[2], price[3])*0.5);
		if(a>=4) {
			for(int i=4;i<=a;i++) {
				double x=co[i-1]+price[i];
				double y=co[i-2]+price[i-1]+price[i]-Math.min(price[i-1], price[i])*0.5;
				double z1=co[i-3]+price[i-2]+price[i-1]+price[i]-Math.min(Math.min(price[i-1], price[i-2]), price[i]);
				double z2=co[i-3]+price[i-2]+price[i-1]+price[i]-Math.min(price[i-1], price[i])*0.5;
				double z=Math.min(z1, z2);
				co[i]=Math.min(x, Math.min(y, z));
			}
		}
		System.out.printf("%.1f",co[a]);

	}

}
