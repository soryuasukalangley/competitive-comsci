import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class year2018p2 {
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
		int co=0;
		boolean[] ifprime=new boolean[100000+1];
		Arrays.fill(ifprime,true);        
	    ifprime[0]=ifprime[1]=false;   
	    for (int i=2;i<ifprime.length;i++) {
	        if(ifprime[i])
	            for (int j=2;i*j<ifprime.length;j++)
	                ifprime[i*j]=false;
	    }
		for(int i=0;i<a;i++) {
			int b=readInt();
			if(ifprime[b])
				co++;
		}
		bw.write(Integer.toString(co));
		bw.close();

	}

}
