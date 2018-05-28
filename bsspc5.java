import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bsspc5 {
	static BufferedReader br;  
	static StringTokenizer st; 
	static BufferedWriter bw;
	
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
		int n=readInt();
		int k=readInt();
		long[]coe=new long[k];
		ArrayList<Long>fval=new ArrayList<Long>();
		for(int i=0;i<k;i++) 
			coe[i]=readLong();
		for(int i=0;i<k;i++) 
			fval.add(readLong());
		for(int i=0;i<n;i++) {
			if(i<k) {
				System.out.println(fval.get(i));
			}
			else {
				long ans=0;
				for(int j=0;j<k;j++) 
					ans+=coe[j]*fval.get(i-j-1);
				ans%=1000000007;
				System.out.println(ans);
				fval.add(ans);
			}
		}

	}

}
