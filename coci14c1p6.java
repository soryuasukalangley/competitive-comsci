import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class coci14c1p6 {
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
	
	private static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
	
	public static boolean dfscuttree(int cur) {
		vis[cur]=true;
		boolean usable=false;
		for(int i=0;i<chk[cur].size();i++) {
			int next=chk[cur].get(i).a;
			if (!vis[next]) {
				if (dfscuttree(next)){
					use[cur]=usable=true;
					totsubtree+=chk[cur].get(i).b;
				}
			}
		}
		if(use[cur])
			usable=true;
		return usable;
	}
	
	public static void dfs(int cur) {
		vis[cur]=true;
	    for (pair i:chk[cur]) {
	        int m=i.a, n=i.b;
	        if (vis[m]||!use[m]) continue;
	        dfs(m);
	        if (maxdis[m]+n>maxdis[cur]) {
	            smaxdis[cur]=maxdis[cur];
	            maxdis[cur]=maxdis[m]+n;
	            maxdisidx[cur]=m;
	        } else if (maxdis[m]+n>smaxdis[cur]) {
	            smaxdis[cur]=maxdis[m]+n;
	        }
	    }
	}
	public static void dfs2(int cur, long premax) {
		vis[cur]=true;
	    if (use[cur]) 
	        ans[cur]=(totsubtree*2-Math.max(premax, maxdis[cur]));
	    for (pair i:chk[cur]) {
	        int m=i.a,n=i.b;
	        if (vis[m]) continue;
	        if (!use[m]) {
	            ans[m]=ans[cur]+n;
	            dfs2(m, premax);
	            continue;
	        }
	        if (m==maxdisidx[cur]) {
	            dfs2(m, n+Math.max(premax, smaxdis[cur]));
	        } else {
	            dfs2(m, n+Math.max(premax, maxdis[cur]));
	        }
	    }
	}
	
	static ArrayList<pair>[]chk;
	static boolean[] vis,use;
	static long[]maxdis,smaxdis,ans,maxdisidx;
	static long totsubtree=0;

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int a=readInt();
		int b=readInt();
		chk=new ArrayList[a+1];
		for(int i=1;i<=a;i++)
			chk[i]=new ArrayList<pair>();
		vis=new boolean[a+1];
		use=new boolean[a+1];
		maxdis=new long[a+1];
		smaxdis=new long[a+1];
		maxdisidx=new long[a+1];
		ans=new long[a+1];
		for(int i=0;i<a-1;i++) {
			int c=readInt();
			int d=readInt();
			int e=readInt();
			chk[c].add(new pair(d,e));
			chk[d].add(new pair(c,e));
		}
		int start=0;
		for(int i=1;i<=b;i++) {
			int c=readInt();
			use[c]=true;
			start=c;
		}
		dfscuttree(start);
		Arrays.fill(vis, false);
		dfs(start);
		Arrays.fill(vis, false);
		dfs2(start, 0);
		for (int i=1;i<=a;i++) {
		    pr.println(ans[i]);
		}
		pr.close();

	}

}
