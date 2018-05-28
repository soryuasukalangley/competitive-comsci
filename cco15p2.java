import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cco15p2 {
	static ArrayList<pair>[]chk;
    static int dis[];
    static boolean vis[];
    
	private static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
	public static void dfs(int n) {
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			pair i=chk[n].get(j);
			int x=i.a;
			int y=i.b;
			if(vis[x]==false) {
				dfs(x);
				if(dis[x]+y>dis[n])
					dis[n]=dis[x]+y;
			}
			else if(vis[x]) {
				dis[n]+=y;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		chk=new ArrayList[a];
		dis=new int[a];
		vis=new boolean[a];
		for(int i=0;i<a;i++) {
			chk[i]=new ArrayList<pair>();
		}
		for(int i=0;i<b;i++) {
			int c=sc.nextInt();
			int d=sc.nextInt();
			int e=sc.nextInt();
			chk[c].add(new pair(d,e));
		}
		dfs(0);
		System.out.println(dis[a-1]);

	}

}
