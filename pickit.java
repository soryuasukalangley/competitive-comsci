import java.util.Arrays;
import java.util.Scanner;

public class pickit {
	public static int dp(int l,int r,int[][]co,int[]num) {
		if (l==r) return 0;
	    if (co[l][r]!=-1) return co[l][r];
	    int ans=0;
	    for (int i=l+1;i<=r-1;i++)
	        ans=Math.max(ans,num[l]+num[r]+num[i]+dp(l,i,co,num)+dp(i,r,co,num));
	    return co[l][r]=ans;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			int a=sc.nextInt();
			if(a==0)break;
			int[]num=new int[a];
			for(int i=0;i<a;i++)
				num[i]=sc.nextInt();
			int[][]co=new int[a][a];
			for(int[]rows:co)
				Arrays.fill(rows, -1);
			System.out.println(dp(0,a-1,co,num));
		}

	}

}
