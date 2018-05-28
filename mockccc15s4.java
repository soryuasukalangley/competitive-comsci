import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class mockccc15s4 {
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
	
	public static int damage(int a,int b) {
		return Math.max(0, a-b);
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int[]dur=new int[a+2],wei=new int[a+2];
		long[][]co=new long[2][a+1];
		for(int i=1;i<=a;i++) {
			dur[i]=readInt();
			wei[i]=readInt();
		}
		for(int i=1;i<=a;i++) {
			co[0][i]=Math.min(co[0][i-1]+damage(dur[i],wei[i-1]),co[1][i-1]+dur[i]);
			co[1][i]=Math.min(co[0][i-1]+damage(damage(dur[i],wei[i+1]),wei[i-1]),co[1][i-1]+damage(dur[i],wei[i+1]));
		}
		System.out.println(co[0][a]);

	}

}
