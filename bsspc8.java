import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bsspc8 {
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

	static long[]sub;
	static ArrayList<Integer>[]chk;
	static int a;
	static BufferedWriter bw;
	static long sum;
	static boolean[]vis;
	
	public static void dfs(int n) {
		vis[n]=true;
		sub[n]=1;
		for(int j=0;j<chk[n].size();j++) {
			int i=chk[n].get(j);
			if(!vis[i]) {
				dfs(i);
				sub[n]*=(sub[i]+1);
				sub[n]%=1000000007;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		a=readInt();
		chk=new ArrayList[a+1];
		sub=new long[a+1];
		vis=new boolean[a+1];
		for(int i=1;i<=a;i++)
			chk[i]=new ArrayList<Integer>();
		for(int i=1;i<a;i++) {
			int b=readInt();
			chk[b].add(i+1);
		}
		dfs(1);
		sum=0;
		for(int i=1;i<=a;i++) {
			sum+=sub[i];
			sum%=1000000007;
		}
		bw.flush();

	}

}
