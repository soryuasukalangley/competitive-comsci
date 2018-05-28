import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ccc13s4 {
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
	
	public static void dfs(int n,boolean[]vis,ArrayList<Integer>[] chk) {
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			int i=chk[n].get(j);
			if(vis[i]==false) {
				dfs(i,vis,chk);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int b=readInt();
		ArrayList<Integer>[] tall=new ArrayList[a+1];
		ArrayList<Integer>[] shor=new ArrayList[a+1];
		boolean[]vist=new boolean[a+1];
		boolean[]viss=new boolean[a+1];
		for(int i=1;i<=a;i++){
			tall[i]=new ArrayList<Integer>();
			shor[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<b;i++) {
			int c=readInt();
			int d=readInt();
			tall[c].add(d);
			shor[d].add(c);
		}
		int h1=readInt();
		int h2=readInt();
		dfs(h1,vist,tall);
		dfs(h1,viss,shor);
		if(vist[h2]==true)
			System.out.println("yes");
		else if(viss[h2]==true)
			System.out.println("no");
		else
			System.out.println("unknown");

	}

}
