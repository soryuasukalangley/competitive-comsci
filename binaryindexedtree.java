import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class binaryindexedtree {
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
	
	public static long[]bit,bit2;
	
	public static void update (int k, int v){
		while (k<bit.length){
			bit[k]+=v;
			k+=(k&(-k));
		}
	}
	public static long query(int k){
		long ans=0;
		while (k>0){
			ans+=bit[k];
			k-=(k&(-k));
		}
		return ans;
	}
	public static void update2 (int k, int v){
		while (k<bit2.length){
			bit2[k]+=v;
			k+=(k&(-k));
		}
	}
	public static long query2(int k){
		long ans=0;
		while (k>0){
			ans+=bit2[k];
			k-=(k&(-k));
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		bit=new long[a+100000];
		bit2=new long[a+100000];
		int[]cur=new int[a+1];
		int b=readInt();
		for(int i=1;i<=a;i++) {
			cur[i]=readInt();
			update(i, cur[i]);
			update2(cur[i],1);
		}
		for(int i=1;i<=b;i++) {
			String x=next();
			if(x.equals("C")) {
				int n=readInt();
				int m=readInt();
				update(n, m-cur[n]);
				update2(m,1);
				update2(cur[n], -1);
				cur[n]=m;
			}
			if(x.equals("S")) {
				int n=readInt();
				int m=readInt();
				bw.write(Long.toString((query(m)-query(n-1))));
				bw.newLine();
			}
			if(x.equals("Q")) {
				int n=readInt();
				bw.write(Long.toString(query2(n)));
				bw.newLine();
			}
		}
		bw.flush();

	}

}
