import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ccc17s4 {
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
	
	static int[]par;
	
	public static int find(int x){
		if(x!=par[x])par[x]=find(par[x]);
		return par[x];
	}

	public static void un(int x, int y){
		par[find(x)]=find(y);
	}
	
	static class quartet implements Comparable <quartet>{
		int a,b,d;
		long c;
		quartet (int a0,int b0,long c0,int n0){
			this.a=a0;
			this.b=b0;
			this.c=c0;
			this.d=n0;
		}
		public int compareTo (quartet x){
			if(this.c<x.c) return -1;
			else if(this.c==x.c){
				if(this.d<x.d) return -1;
				else return 1;
			}
			else return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int b=readInt();
		long c=readInt();
		par=new int[a+1];
		PriorityQueue<quartet>chk=new PriorityQueue<quartet>();
		PriorityQueue<quartet>chk2=new PriorityQueue<quartet>();
		ArrayList<quartet>used=new ArrayList<quartet>();
		for(int i=1;i<=a;i++) {
			par[i]=i;
		}
		for(int i=0;i<b;i++) {
			int d=readInt();
			int e=readInt();
			long f=readLong();
			chk.add(new quartet(d,e,f,i));
			chk2.add(new quartet(d,e,f,i));
		}
		int co=0;
		while(!chk.isEmpty()) {
			quartet q=chk.poll();
			if(find(q.a)!=find(q.b)) {
				un(q.a,q.b);
				used.add(q);
				if(q.d>=a-1)
					co++;
			}
		}
		boolean reduce=false;
		if(c>0L) {
			for(int i=1;i<=a;i++) {
				par[i]=i;
			}
			long maxv=used.get(used.size()-1).c;
			while(!chk2.isEmpty()) {
				quartet q=chk2.poll();
				if(find(q.a)!=find(q.b)) {
					if(q.c<maxv||(q.c==maxv&&q.d<a-1))
						un(q.a,q.b);
					else if(q.c>maxv&&q.c<=c&&q.d<a-1) {
						reduce=true;
						break;
					}
				}
			}
		}
		if(reduce)
			System.out.println(co-1);
		else {
			System.out.println(co);
		}

	}

}
