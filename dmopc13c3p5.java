import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dmopc13c3p5 {
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
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int b=readInt();
		int c=readInt();
		int[]val=new int[c+1];
		int[]tim=new int[c+1];
		int[][][]co=new int[2][a+1][b+1];
		int[]food=new int[c+1];
		for(int i=1;i<=c;i++) {
			val[i]=readInt();
			tim[i]=readInt();
			food[i]=readInt();
		}
		int place=0;
		for(int i=1;i<=c;i++) {
			for(int j=0;j<=a;j++) {
				for(int k=0;k<=b;k++) {
					if(tim[i]<=j&&food[i]<=k) {
						co[place][j][k]=Math.max(co[1-place][j][k], co[1-place][j-tim[i]][k-food[i]]+val[i]);
					}else {
						co[place][j][k]=co[1-place][j][k];
					}
				}
			}
			place=1-place;
		}
		System.out.println(co[1-place][a][b]);

	}

}
