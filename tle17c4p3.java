import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tle17c4p3 {
	static boolean[]vis;
	static ArrayList<Integer>[]chk;
	static int[]val,min;
	public static void dfs(int n) {
		vis[n]=true;
		if(chk[n].size()==0)
			min[n]=val[n];
		else {
			for(int j=0;j<chk[n].size();j++) {
				int i=chk[n].get(j);
				if(vis[i]==false) {
					dfs(i);
					min[n]=Math.max(min[n], min[i]);
				}
			}
			min[n]=Math.min(val[n],min[n]);
		}
	}
	
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

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int b=readInt();
		int c=readInt();
		chk=new ArrayList[a+1];
		vis=new boolean[a+1];
		val=new int[a+1];
		min=new int[a+1];
		for(int i=0;i<=a;i++)
			chk[i]=new ArrayList<Integer>();
		for(int i=0;i<b;i++) {
			int d=readInt();
			int e=readInt();
			for(int j=0;j<e;j++) {
				int f=readInt();
				chk[d].add(f);
			}
		}
		Arrays.fill(val, 100000000);
		for(int i=1;i<=c;i++) {
			int d=readInt();
			if(val[d]>i)
				val[d]=i;
		}
		dfs(1);
		if(min[1]<100000000)
			System.out.println(min[1]);
		else
			System.out.println(-1);

	}

}
