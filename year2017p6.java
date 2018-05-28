import java.util.Arrays;
import java.util.Scanner;

public class year2017p6 {
	static int a;
	static int[]cost,draw;
	static long[][]co;
	public static long dp(int cur,int drawed) {
		if(drawed>=a)return 0;
		if(cur>=drawed)return Long.MAX_VALUE-1000000000;
		if(co[cur][drawed]!=-1)return co[cur][drawed];
		return co[cur][drawed]=Math.min(dp(cur+1,drawed), dp(cur+1,drawed+draw[cur])+cost[cur]);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		cost=new int[a];
		draw=new int[a];
		co=new long[a][a+1];
		for(int i=0;i<a;i++) {
			cost[i]=sc.nextInt();
			draw[i]=sc.nextInt();
		}
		for(long[]rows:co)
			Arrays.fill(rows, -1L);
		System.out.println(dp(0,1));
		

	}

}
