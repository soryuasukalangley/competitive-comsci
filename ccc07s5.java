import java.util.Scanner;

public class ccc07s5 {
	static int[] pins;
	static int[][]co;
	static int[]sum;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		for(int i=0;i<a;i++) {
			int b=sc.nextInt();
			int c=sc.nextInt();
			int d=sc.nextInt();
			pins=new int[b+1];
			sum=new int[b+1];
			co=new int[b+1][c+1];
			for(int j=1;j<=b;j++) {
				pins[j]=sc.nextInt();
			}
			for(int j=1;j<=b;j++) {
				if(j<=d)
					sum[j]=pins[j]+sum[j-1];
				else
					sum[j]=sum[j-1]+pins[j]-pins[j-d];
			}
			for(int j=1;j<=b;j++){
				for(int k=1;k<=c;k++){
					co[j][k]=Math.max(co[Math.max((int)0, j-d)][k-1]+sum[j], co[j-1][k]);
				}
			}
			System.out.println(co[b][c]);
		}

	}

}
