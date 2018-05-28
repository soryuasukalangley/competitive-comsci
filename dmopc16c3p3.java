import java.util.Arrays;
import java.util.Scanner;

public class dmopc16c3p3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int[] kill=new int[a+1];
		int[] gain=new int[a+1];
		int[][]co=new int[2][10001];
		for(int i=1;i<=a;i++) {
			kill[i]=sc.nextInt();
			gain[i]=sc.nextInt();
		}
		for(int[] rows:co)
			Arrays.fill(rows, -1);
		int n=0;
		co[0][b]=0;
		for(int i=1;i<=a;i++) {
			for(int j=0;j<=10000;j++) {
				if(co[n][j]!=-1) {
					co[1-n][j]=Math.max(co[1-n][j],co[n][j]);
					if (j>=kill[i]){
						int m=j-kill[i]+gain[i];
						co[1-n][m]=Math.max(co[1-n][m],co[n][j]+1);
					}
				}
			}
			n=1-n;
		}
		int ans=0;
		int max=0;
		for(int i=0;i<=10000;i++) {
			if(ans<=co[n][i]) {
				ans=co[n][i];
				max=i;
			}
		}
		System.out.println(ans+" "+max);

	}

}
