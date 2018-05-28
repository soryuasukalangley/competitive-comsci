import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class year2018p4 {
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
	
	public static long findsumnum(long x) {
		String st=Long.toString(x);
		int length=st.length();
		if(st.length()==1)
			return x;
		if(st.charAt(st.length()-1)=='0')
			return 0;
		long max=st.charAt(0) - '0';
		long sum=(length-1)*9+(max-1);
		boolean det=false;
		for(int i=1;i<st.length();i++) {
			if(st.charAt(i)!='9') {
				det=true;
				break;
			}
		}
		if(det)
			return sum;
		else
			return sum+1;
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		long a=readLong();
		long b=readLong();
		System.out.println(findsumnum(b)-(findsumnum(b)-findsumnum(a-1)));

	}

}
