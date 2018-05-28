import java.util.ArrayList;
import java.util.Scanner;

public class bts16p5 {
	static int[]che;
	static ArrayList<pair>[]chk;
	static int co[],dis[];
	static boolean[]vis;
	public static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
	
	public static void dfs(int n) {
		co[n]=che[n];
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			pair i=chk[n].get(j);
			int x=i.a;
			int y=i.b;
			if(vis[x]==false) {
				dfs(x);
				co[n]+=co[x];
				dis[n]+=dis[x];
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
		int c=sc.nextInt();
		che=new int[a+1];
		chk=new ArrayList[a+1];
		co=new int[a+1];
		dis=new int[a+1];
		vis=new boolean[a+1];
		for(int i=1;i<=a;i++) {
			che[i]=sc.nextInt();
			chk[i]=new ArrayList<pair>();
		}
		for(int i=1;i<a;i++) {
			int d=sc.nextInt();
			int e=sc.nextInt();
			int f=sc.nextInt();
			chk[d].add(new pair(e,f));
			chk[e].add(new pair(d,f));
		}
		dfs(1);
		int co2=0;
		for(int i=2;i<=a;i++) {
			if(dis[i]<=c&&co[i]>=b)
				co2++;
		}
		System.out.println(co2);

	}

}
