import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class coci13c1p4 {
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

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer>ts=new ArrayList<Integer>();
		PriorityQueue<pair>pq=new PriorityQueue<pair>();
		int a=readInt();
		int b=readInt();
		for(int i=0;i<a;i++) {
			int c=readInt();
			int d=readInt();
			pq.add(new pair(d,c));
		}
		for(int i=0;i<b;i++)
			ts.add(readInt());
		long ans=0;
		Collections.sort(ts);
		while(!pq.isEmpty()&&!ts.isEmpty()) {
			pair p=pq.poll();
			int val=p.a;
			int weight=p.b;
			if(ts.get(ts.size()-1)>=weight) {
				ans+=val;
				ts.remove(ts.size()-1);
			}
		}
		bw.write(Long.toString(ans));
		bw.flush();

	}

}
