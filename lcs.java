import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lcs {
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
	
	static int a,b;
	static int[]aa,bb;
	static int[][]co;
	
	public static int dp(int ax,int bx) {
		if(ax<0||bx<0)return 0;
		if(co[ax][bx]!=-1)return co[ax][bx];
		if(aa[ax]==bb[bx])return co[ax][bx]=1+dp(ax-1, bx-1);
		else return co[ax][bx]=Math.max(dp(ax, bx-1), Math.max(dp(ax-1, bx),dp(ax-1, bx-1)));
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		a=readInt();
		b=readInt();
		aa=new int[a];
		bb=new int[b];
		co=new int[a][b];
		for(int i=0;i<a;i++)
			aa[i]=readInt();
		for(int i=0;i<b;i++)
			bb[i]=readInt();
		for(int[]rows:co)
			Arrays.fill(rows, -1);
		System.out.println(dp(a-1,b-1));

	}

}
