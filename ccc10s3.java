import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc10s3 {
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
	
	static final int length=1000000;
	static int[]houses;
	
	public static int numhydrants(int hose) {
		int hosesrequired=houses.length;
		int dia=hose*2;
		int i=0;
		while(i<houses.length&&houses[i]<=houses[0]+dia) {
			int co=1,end=houses[i];
			int j=i+1;
			while(j<houses.length&&houses[i]>(houses[j]+dia-length)) {
				if(houses[j]>end) {
					co++;
					end=houses[j]+dia;
				}
				j++;
			}
			hosesrequired=Math.min(hosesrequired, co);
			i++;
		}
		return hosesrequired;
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		houses=new int[a];
		for(int i=0;i<a;i++)
			houses[i]=readInt();
		int hydrants=readInt();
		Arrays.sort(houses);
		int l=-1;
		int h=length;
		while(h>l+1) {
			int mid=(l+h)/2;
			if(numhydrants(mid)>hydrants)
				l=mid;
			else
				h=mid;
		}
		bw.write(Integer.toString(h));
		bw.flush();

	}

}
