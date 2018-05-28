import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class graph1 {
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

	
	public static void dfs(int n,ArrayList<Integer>[]chk,boolean[]vis) {
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			int i=chk[n].get(j);
			if(vis[i]==false) {
				dfs(i,chk,vis);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int b=readInt();
		ArrayList<Integer>[] chk=new ArrayList[a+1];
		boolean[]vis=new boolean[a+1];
		for(int i=1;i<a+1;i++) {
			chk[i]=(new ArrayList<Integer>());
		}
		for(int i=0;i<b;i++) {
			int e=readInt();
			int f=readInt();
			chk[e].add(f);
			chk[f].add(e);
		}
		int c=readInt();
		int d=readInt();
		dfs(c,chk,vis);
		if (vis[d]==true)
			System.out.println(1);
		else
			System.out.println(0);

	}

}

