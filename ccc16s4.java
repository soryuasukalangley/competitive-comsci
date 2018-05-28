import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc16s4 {
	static BufferedReader br; 
	static PrintWriter out; 
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
	
	static int[]size,psum;
	static int[][]co;
	
	public static int dp(int l,int r) {
		if(co[l][r]!=-1) return co[l][r];
		if(l>=r) return co[l][r]=1;
		for(int i=l;i<=r;i++) {
			for(int j=r;j>=i;j--) {
				if(psum[i]-psum[l-1]<psum[r]-psum[j-1]) 
					break;
				else if(psum[i]-psum[l-1]==psum[r]-psum[j-1]) {
					if(dp(l, i)!=0&&dp(i+1, j-1)!=0&&dp(j, r)!=0) return co[l][r]=1;
					break;
				}
			}
		}
		return co[l][r]=0;
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		size=new int[a+1];
		psum=new int[a+1];
		co=new int[a+1][a+1];
		for(int i=1;i<=a;i++) {
			size[i]=psum[i]=readInt();
			psum[i]+=psum[i-1];
		}
		for(int[]rows:co)
			Arrays.fill(rows, -1);
		int max=0;
		for(int i=1;i<=a;i++)
			for(int j=1;j<=a;j++)
				if(dp(i,j)!=0)
					max=Math.max(max, psum[j]-psum[i-1]);
		System.out.println(max);

	}

}
