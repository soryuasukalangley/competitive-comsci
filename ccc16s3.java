import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ccc16s3 {
	public static boolean[]vis;
	public static int[]dis;
	public static ArrayList<Integer>[] chk;
	public static int[]parent;
	public static boolean[]discard;
	
	public static void dfs(int n) {
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			int i=chk[n].get(j);
			if(vis[i]==false&&discard[i]==false) {
				dis[i]=dis[n]+1;
				parent[i]=n;
				dfs(i);
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int ways=a-1;
		chk=new ArrayList[a];
		dis=new int[a];vis=new boolean[a];
		discard=new boolean[a];
		boolean[]pr=new boolean[a];
		int[]numofconnections=new int[a];
		parent=new int[a];
		int p=0;
		for(int i=0;i<a;i++) {
			chk[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<b;i++) {
			int c=sc.nextInt();
			pr[c]=true;
			p=c;
		}
		for(int i=0;i<a-1;i++) {
			int c=sc.nextInt();
			int d=sc.nextInt();
			chk[c].add(d);
			chk[d].add(c);
			numofconnections[c]++;
			numofconnections[d]++;
		}
		dfs(p);
		for(int y=0;y<a;y++) {
			int i=y;
			while(pr[i]==false&&numofconnections[i]==1&&discard[i]==false) {
				discard[i]=true;
				int x=parent[i];
				numofconnections[x]--;
				i=x;
				ways--;
			}
		}
		int x=0;
		for(int i=0;i<discard.length;i++) {
			if(discard[i]==false) {
				x=i;
				break;
			}
		}
		Arrays.fill(dis, 0);
		Arrays.fill(vis, false);
		dfs(x);
		int d=0;
		int max=0;
		for(int i=0;i<dis.length;i++) {
			if(dis[i]>max) {
				max=dis[i];
				d=i;
			}
		}
		Arrays.fill(dis, 0);
		Arrays.fill(vis, false);
		dfs(d);
		Arrays.sort(dis);
		System.out.println(2*ways-dis[dis.length-1]);

	}

}
