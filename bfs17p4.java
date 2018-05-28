import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bfs17p4 {
	static ArrayList<pair>[]chk;
	static int maxdis[],mindis[],num[];
	static boolean[]vis;
	public static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }

	public static void dfs(int n) {
		vis[n]=true;
		num[n]=1;
		for(int j=0;j<chk[n].size();j++) {
			pair i=chk[n].get(j);
			int x=i.a;
			if(vis[x]==false) {
				dfs(x);
				num[n]+=num[x];
			}
		}
	}
	
	public static void dfs2(int n,int m) {
		if(vis[n])return;
		boolean wtf=false;
		int a=0,b=0,c=1,d=1;
		if (chk[n].size()==1||m==1) {
	        if (m==-1){
	            mindis[n]=0;
	            maxdis[n]=1;
	        } else if (m==3){
	        		mindis[n]=0;
	        		maxdis[n]=0;
	        } else {
	        		mindis[n]=1;
	        		maxdis[n]=1;
	        }
	    }
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			pair i=chk[n].get(j);
			int x=i.a;
			int y=i.b;
			if(!vis[x]){
				if(m==-1) {
					wtf=true;
					dfs2(x,y);
					a+=maxdis[x];
					b+=mindis[x];
					c+=num[x]-mindis[x];
					d+=num[x]-maxdis[x];
				}
				if(m==1) {
					dfs2(x,y);
					maxdis[n]+=num[x]-mindis[x];
					mindis[n]+=num[x]-maxdis[x];
				}
				if(m==3) {
					dfs2(x,y);
					maxdis[n]+=maxdis[x];
					mindis[n]+=mindis[x];
				}
			}
		}
		if(wtf) {
			maxdis[n]+=Math.max(c, a);
			mindis[n]+=Math.min(d, b);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		chk=new ArrayList[a+1];
		mindis=new int[a+1];
		maxdis=new int[a+1];
		num=new int[a+1];
		vis=new boolean[a+1];
		for(int i=0;i<=a;i++) {
			chk[i]=new ArrayList<pair>();
		}
		for(int i=1;i<=a;i++) {
			String A=sc.next();
			if(A.equals("C")) {
				String B=sc.next();
				if(B.equals("AC")) {
					chk[0].add(new pair(i,3));
					chk[i].add(new pair(0,3));
				}
				if(B.equals("?")) {
					chk[0].add(new pair(i,-1));
					chk[i].add(new pair(0,-1));
				}
				if(B.equals("WA")) {
					chk[0].add(new pair(i,1));
					chk[i].add(new pair(0,1));
				}
			}
			if(A.equals("E")) {
				int b=sc.nextInt();
				String B=sc.next();
				if(B.equals("AC")) {
					chk[b].add(new pair(i,3));
					chk[i].add(new pair(b,3));
				}
				if(B.equals("?")) {
					chk[b].add(new pair(i,-1));
					chk[i].add(new pair(b,-1));
				}
				if(B.equals("WA")) {
					chk[b].add(new pair(i,1));
					chk[i].add(new pair(b,1));
				}
			}
		}
		dfs(0);
		Arrays.fill(vis, false);
		dfs2(0,3);
		System.out.println(mindis[0]+" "+maxdis[0]);

	}

}
