import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class dmopc14c4p6 {
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

	static ArrayList<Integer>[]chk;

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		chk=new ArrayList[a+1];
		boolean[]vis=new boolean[a+1];
        int[]dis=new int[a+1];
        int[]dis2=new int[a+1];
		for(int i=1;i<=a;i++) {
			chk[i]=new ArrayList<Integer>();
		}
		for(int i=1;i<a;i++) {
			int b=readInt();
			int c=readInt();
			chk[b].add(c);
			chk[c].add(b);
		}
		int max=0,node=0;
		Queue<Integer>unv=new ArrayDeque<Integer>();
	    unv.add(1);
	    while(!unv.isEmpty()) {
	    		int n=unv.poll();
	    		vis[n]=true;
	    		for(int i=0;i<chk[n].size();i++) {
	    			int m=chk[n].get(i);
	    			if(!vis[m]) {
	    				dis[m]=dis[n]+1;
	    				unv.offer(m);
	    				if (dis[m]>max){
	                        max=dis[m];
	                        node=m;
	                }
	    			}
	    		}
	    }
	    Arrays.fill(vis,false);
        Arrays.fill(dis,0);
        unv.offer(node);
        while(!unv.isEmpty()) {
    			int n=unv.poll();
    			vis[n]=true;
    			for(int i=0;i<chk[n].size();i++) {
    				int m=chk[n].get(i);
    				if(!vis[m]) {
    					dis[m]=dis[n]+1;
    					unv.offer(m);
    					if (dis[m]>=max){
    						max=dis[m];
    						node=m;
    					}
    				}
    			}
        }
        Arrays.fill(vis,false);
        unv.offer(node);
        while(!unv.isEmpty()) {
			int n=unv.poll();
			vis[n]=true;
			for(int i=0;i<chk[n].size();i++) {
				int m=chk[n].get(i);
				if(!vis[m]) {
					dis2[m]=dis2[n]+1;
					unv.offer(m);
				}
			}
        }
	    for(int i=1;i<=a;i++)
	    		System.out.println(Math.max(dis[i], dis2[i])+1);

	}

}
