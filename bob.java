import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bob {
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
	
	public static class quartet{
		int a,b,c;
		long sum;
		quartet(int a,int b,int c,long sum){
			this.a=a;
			this.b=b;
			this.c=c;
			this.sum=sum;
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		int b=readInt();
		short[][]map=new short[a][b];
		int[][]hi=new int[a][b];
		quartet[]dp=new quartet[a];
		for(int i=0;i<a;i++)
			for(int j=0;j<b;j++)
				map[i][j]=(short)readInt();
		long co=0;
		for(int i=0;i<a;i++) {
			int top=-1;
			for(int j=0;j<b;j++) {
				hi[i][j]=1;
				if(i>0&&map[i-1][j]==map[i][j]) 
					hi[i][j]+=hi[i-1][j];
				int rows=1;
				while(top>=0&&dp[top].c==map[i][j]&&dp[top].b>=hi[i][j])
					rows+=dp[top--].a;
				long tot=rows*hi[i][j];
				if (top>=0&&dp[top].c==map[i][j]) 
					tot+=dp[top].sum;
				co+=tot;
				dp[++top]=new quartet(rows, hi[i][j], map[i][j], tot);
			}
		}
		bw.write(Long.toString(co));
		bw.close();

	}

}