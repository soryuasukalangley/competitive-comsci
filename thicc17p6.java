import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class thicc17p6 {
	static ArrayList<pair>[]chk;
	static int[]maxdis,smaxdis,maxdisindex,dp;
	static boolean vis[];
	public static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
	}
	
	public static void dfs(int n,int pre) {
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			pair i=chk[n].get(j);
			int x=i.a;
			int y=i.b;
			if(x!=pre) {
				dfs(x, n);
				if(maxdis[x]+y>maxdis[n]) {
					smaxdis[n]=maxdis[n];
					maxdis[n]=maxdis[x]+y;
					maxdisindex[n]=x;
				}else if(maxdis[x]+y>smaxdis[n])
					smaxdis[n]=maxdis[x]+y;
			}	
		}
	}
	
	public static void dfs2(int n,int pre,int premax) {
		dp[n]=Math.max(premax, maxdis[n]);
		for(int j=0;j<chk[n].size();j++) {
			pair i=chk[n].get(j);
			int x=i.a;
			int y=i.b;
			if(x!=pre) {
				if(x==maxdisindex[n])
					dfs2(x,n,Math.max(premax,smaxdis[n])+y);
				else
					dfs2(x,n,Math.max(premax,maxdis[n])+y);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		chk=new ArrayList[a+1];
		maxdis=new int[a+1];
		smaxdis=new int[a+1];
		maxdisindex=new int[a+1];
		dp=new int[a+1];
		vis=new boolean[a+1];
		LinkedList<pair>res=new LinkedList<pair>();
		for(int i=0;i<=a;i++) {
			chk[i]=new ArrayList<pair>();
		}
		int total=0;
		for(int i=0;i<a-1;i++) {
			int c=sc.nextInt();
			int d=sc.nextInt();
			int e=sc.nextInt();
			chk[c].add(new pair(d,e));
			chk[d].add(new pair(c,e));
			total+=e;
		}
		dfs(1,0);
	    dfs2(1,0,0);
	    total*=2;
		for(int i=1;i<=a;i++) {
			if(chk[i].size()==b)
				System.out.println(i+" "+(total-dp[i]));
		}

	}

}

