import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tle1722 {
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
		br = new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int[]aa=new int[a+1];
		for(int i=1;i<=a;i++) {
			aa[i]=readInt();
		}
		Arrays.sort(aa);
		int b=readInt();
		int[]bb=new int[b];
		for(int i=0;i<b;i++) {
			bb[i]=readInt();
		}
		for(int i=0;i<b;i++) {
			if(a==1) {
				if(aa[1]<bb[i]) {
					bb[i]--;
					continue;
				}
			}
			int max=a;
			int min=1;
			while(true) {
				int mid=(max+min)/2;
				if(max<=min) {
					if(aa[mid]>bb[i])
					min--;
					break;
				}
				if(aa[mid]>bb[i]) {
					max=mid-1;
				}else if(aa[mid]<bb[i]) {
					min=mid+1;
				}
			}
			bb[i]-=min;
		}
		for(int i=0;i<b;i++) {
			System.out.println(bb[i]);
		}

	}

}
