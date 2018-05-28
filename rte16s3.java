import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class rte16s3 {
	static int[][]chk;
	static int[][]dis;
	static boolean[]vis;
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
	
	public static void dfs(int n,int i) {
		vis[n]=true;
		for(int j=0;j<chk[n].length;j++) {
			if(chk[n][j]>0) {
				if(vis[j]==false) {
					dis[i][j]=dis[i][n]+chk[n][j];
					dfs(j,i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		chk=new int[a][a];
		vis=new boolean[a];
		dis=new int[a][a];
		for(int i=0;i<a-1;i++) {
			int b=readInt();
			int c=readInt();
			int d=readInt();
			chk[b][c]=d;
			chk[c][b]=d;
		}
		int b=readInt();
		for(int i=0;i<a;i++) {
			dfs(i,i);
			Arrays.fill(vis, false);
		}
		for(int i=0;i<b;i++) {
			int c=readInt();
			int d=readInt();
			System.out.println(dis[c][d]);
		}

	}

}
