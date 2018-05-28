import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class dmopc15c1p5 {
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

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		int b=readInt();
		int c=readInt();
		int[][]presum=new int[b][a];
		for(int i=0;i<b;i++) {
			for(int j=0;j<a;j++) {
				if(i==0&&j==0)
					presum[i][j]=readInt();
				else if(i==0)
					presum[i][j]=readInt()+presum[i][j-1];
				else if(j==0)
					presum[i][j]=readInt()+presum[i-1][j];
				else 
					presum[i][j]=readInt()+presum[i-1][j]+presum[i][j-1]-presum[i-1][j-1];
			}
		}
		int ans=0;
		for(int i=0;i<b;i++) {
			for(int j=0;j<a;j++) {
				for(int k=1;k<=c&&(i+k-1)<b;k++) {
					int l=Math.min((int)(c/k)+j-1,a-1);
	                	int r=i+k-1;
	                	int sum=presum[r][l];
	                	if (i>0) 
	                		sum-=presum[i-1][l];
	                	if (j>0) 
	                		sum-=presum[r][j-1];
	                	if (i>0&&j>0) 
	                		sum+=presum[i-1][j-1];
	                	ans=Math.max(ans, sum);
				}
			}
		}
		bw.write(Integer.toString(ans));
		bw.flush();

	}

}
