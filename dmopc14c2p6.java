import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dmopc14c2p6 {
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
	
	static class quartet implements Comparable <quartet>{
		int a,b,c,d;
		quartet (int a0,int b0,int c0,int n0){
			this.a=a0;
			this.b=b0;
			this.c=c0;
			this.d=n0;
		}
		public int compareTo (quartet x){
			if(this.c>x.c) 
				return -1;
			else 
				return 1;
		}
	}
	
	static class pair implements Comparable <pair>{
		int a,b;
		pair (int a0,int b0){
			this.a=a0;
			this.b=b0;
		}
		public int compareTo (pair x){
			if(this.a>x.a) 
				return -1;
			else 
				return 1;
		}
	}
	
	static int a;
	static long[]bit;

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		PriorityQueue<pair>ori=new PriorityQueue<pair>();
		bit=new long[a+1000000];
		for(int i=1;i<=a;i++) {
			int n=readInt();
			ori.add(new pair(n,i));
		}
		int b=readInt();
		long[]ans=new long[b];
		PriorityQueue<quartet> query=new PriorityQueue<quartet>();
		for(int i=0;i<b;i++) {
			int l=readInt();
			int r=readInt();
			int weight=readInt();
			l++;
			r++;
			query.add(new quartet(l,r,weight,i));
		}
		int idx=0;
		for(int i=0;i<b;i++) {
			for(int j=idx;j<a;j++) {
				if(query.peek().c<=ori.peek().a) {
					idx++;
					update(ori.peek().b,ori.peek().a);
					ori.poll();
				}else
					break;
			}
			long sum=query(query.peek().b)-query(query.peek().a-1);
			ans[query.peek().d]=sum;
			query.poll();
		}
		for(int i=0;i<b;i++) {
			bw.write(Long.toString(ans[i]));
			bw.newLine();
		}
		bw.flush();

	}

}
