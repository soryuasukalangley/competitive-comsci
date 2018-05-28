import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bsspc7 {
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
	
	//basic input
	
	static int[] par,time;
	static ArrayList<pair>[]chk;

	public static int find(int n) {
		if(n!=par[n])par[n]=find(par[n]);
		return par[n];
	}
	
	public static void un(int a,int b) {
		par[find(a)]=find(b);
	}
	
	static class pair{
		int a,b;
		pair(int a,int b){
			this.a=a;
			this.b=b;
		}
	}
	
	static class trio implements Comparable<trio>{
		int a,b,c;
		trio(int a,int b,int c){
			this.a=a;
			this.b=b;
			this.c=c;
		}
		public int compareTo(trio o) {
			return Integer.compare(this.c, o.c);
		}
	}
	
	public static void dfs(int cur,int pre,int dest,int tim) {
		if(cur==dest) {
			time[dest]=tim;
			return;
		}
		for(int j=0;j<chk[cur].size();j++) {
			pair p=chk[cur].get(j);
			if(p.a!=pre) {
				dfs(p.a,cur,dest,p.b);
				if(time[p.a]>0)
					time[cur]=Math.max(tim, time[p.a]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		int b=readInt();
		par=new int[a+1];
		time=new int[a+1];
		chk=new ArrayList[a+1];
		for(int i=1;i<=a;i++)
            par[i]=i;
		for(int i=1;i<=a;i++)
			chk[i]=new ArrayList<pair>();
		PriorityQueue<trio>q=new PriorityQueue<trio>();
		ArrayList<pair>q2=new ArrayList<pair>();
		for(int i=1;i<=b;i++) {
			int lol=readInt();
			if(lol==1) {
				int f1=readInt();
				int f2=readInt();
				int tim=readInt();
				q.add(new trio(f1,f2,tim));
			}else {
				int f1=readInt();
				int f2=readInt();
				q2.add(new pair(f1,f2));
			}
		}
		for(int i=0;i<q.size();i++) {
			trio t=q.poll();
			if(find(t.a)!=find(t.b)) {
				un(t.a,t.b);
				chk[t.a].add(new pair(t.b,t.c));
				chk[t.b].add(new pair(t.a,t.c));
			}
		}
		for(int i=0;i<q2.size();i++) {
			pair p=q2.get(i);
			if(find(p.a)==find(p.b)) {
				dfs(p.a,-1,p.b,-1);
				bw.write(Integer.toString(time[p.a]));
			}else
				bw.write("-1");
			Arrays.fill(time, 0);
			bw.newLine();
		}
		bw.close();

	}

}
