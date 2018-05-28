import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc15s5 {
	static BufferedReader br; 
	static StringTokenizer st; 
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong () throws IOException {
		return Long.parseLong(next());
	}

	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter () throws IOException {
		return next().charAt(0);
	}

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
	
	public static int dp(int cur,int taken,int l,int r) {
		if(co[taken][cur][l][r]!=-1)return co[taken][cur][l][r];
		int ans;
		if(cur==a+1) {
			if(l<=r) {
				if(taken!=0) {
					ans=add[r]+dp(cur,0,l,r-1);
				}else {
					ans=dp(cur,1,l+1,r);
				}
			}else {
				ans=0;
			}
			return ans;
		}else if(taken!=0) {
			ans=Math.max(dp(cur,0,l,r), pies[cur]+dp(cur+1,0,l,r));
			if(l<=r) {
				ans=Math.max(ans, add[r]+dp(cur,0,l,r-1));
			}
		}else {
			ans=dp(cur+1,1,l,r);
			if(l<=r) {
				ans=Math.max(ans, dp(cur,1,l+1,r));
			}
		}
		return co[taken][cur][l][r]=ans;
	}
	
	static int a,b;
	static int[]pies,add;
	static int[][][][]co;

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		a=readInt();
		pies=new int[a+1];
		for(int i=1;i<=a;i++)
			pies[i]=readInt();
		b=readInt();
		add=new int[b+1];
		for(int i=1;i<=b;i++)
			add[i]=readInt();
		co=new int[2][3003][103][103];
		for(int i=0;i<2;i++)
			for(int j=0;j<=3002;j++)
				for(int k=0;k<=102;k++)
					for(int l=0;l<=102;l++)
						co[i][j][k][l]=-1;
		Arrays.sort(add);
		bw.write(Integer.toString(dp(1,1,1,b)));
		bw.close();

	}

}
