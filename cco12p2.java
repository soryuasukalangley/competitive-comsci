import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cco12p2 {
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
	
	public static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
	
	public static class trio{
        int a,b,c;
        trio(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int b=readInt();
		ArrayList<pair>[]chk=new ArrayList[a+1];
		ArrayList<pair>[]chk2=new ArrayList[a+1];
		ArrayList<trio>chk3=new ArrayList<trio>();
		int[]dis=new int[a+1];
		int[]dis2=new int[a+1];
		int big=100000000;
		for(int i=1;i<chk.length;i++) {
			chk[i]=new ArrayList<pair>();
			chk2[i]=new ArrayList<pair>();
		}
		for(int i=0;i<b;i++) {
			int c=readInt();
			int d=readInt();
			int e=readInt();
			chk[c].add(new pair(d,e));
			chk2[d].add(new pair(c,e));
			chk3.add(new trio(c,d,e));
		}
		Arrays.fill(dis, big);
		Arrays.fill(dis2, big);
		dis[1]=0;
		PriorityQueue<Integer>unv=new PriorityQueue<Integer>();
		unv.add(1);
		while(!unv.isEmpty()) {
			int n=unv.poll();
			for(int i=0;i<chk[n].size();i++) {
				pair m=chk[n].get(i);
				int x=m.a;
				int y=m.b;
				if(dis[n]+y<dis[x]) {
					dis[x]=dis[n]+y;
					unv.add(x);
				}
			}
		}
		dis2[a]=0;
		unv.add(a);
		while(!unv.isEmpty()) {
			int n=unv.poll();
			for(int i=0;i<chk2[n].size();i++) {
				pair m=chk2[n].get(i);
				int x=m.a;
				int y=m.b;
				if(dis2[n]+y<dis2[x]) {
					dis2[x]=dis2[n]+y;
					unv.add(x);
				}
			}
		}
		int fir=dis[a];
		int sec=big;
		for(int i=0;i<chk3.size();i++) {
			trio t=chk3.get(i);
			int x=t.a;
			int y=t.b;
			int z=t.c;
			int dist=dis[x]+dis2[y]+z;
			if(dist>fir&&dist<sec)
				sec=dist;
		}
		if(sec==big)
			sec=-1;
		System.out.println(sec);

	}

}
