import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class gfssoc2s4 {
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
		BufferedWriter bw=new BufferedWriter(new PrintWriter(System.out));
		int a=readInt();
		int b=readInt();
		ArrayList<pair>[]chk=new ArrayList[a+1];
		ArrayList<pair>[]chk3=new ArrayList[a+1];
		ArrayList<trio>chk2=new ArrayList<trio>();
		int[]dis=new int[a+1];
		int[]dis2=new int[a+1];
		for(int i=1;i<chk.length;i++) {
			chk[i]=new ArrayList<pair>();
			chk3[i]=new ArrayList<pair>();
		}
		for(int i=0;i<b;i++) {
			int c=readInt();
			int d=readInt();
			int e=readInt();
			chk[c].add(new pair(d,e));
			chk3[d].add(new pair(c,e));
		}
		int c=readInt();
		for(int i=0;i<c;i++) {
			int d=readInt();
			int e=readInt();
			int f=readInt();
			chk2.add(new trio(d,e,f));
		}
		Arrays.fill(dis, 100000000);
		Arrays.fill(dis2, 100000000);
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
			for(int i=0;i<chk3[n].size();i++) {
				pair m=chk3[n].get(i);
				int x=m.a;
				int y=m.b;
				if(dis2[n]+y<dis2[x]) {
					dis2[x]=dis2[n]+y;
					unv.add(x);
				}
			}
		}
		int ans=dis[a];
		for (int i=0;i<chk2.size();i++) { 
			trio n=chk2.get(i);
			int x=n.a;
			int y=n.b;
			int z=n.c;
			ans=Math.min(ans, dis[x]+dis2[y]+z);
		}
		if(ans==100000000) {
			bw.write(Integer.toString(-1));
		}else
			bw.write(Integer.toString(ans));
		bw.close();

	}

}
