import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class vmss7wc16c5p3 {
	static int a;
	static ArrayList<Integer>[] chk=new ArrayList[10000+1];
	static int[]dis=new int[10000+1];
	static boolean[]vis=new boolean[10000+1];
	
	public static void dfs(int n) {
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			int i=chk[n].get(j);
			if(vis[i]==false) {
				dis[i]=dis[n]+1;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		for(int i=0;i<=a;i++){
			chk[i]=new ArrayList<Integer>();
		}
		for(int i=1;i<=a-1;i++) {
			int b=sc.nextInt();
			int c=sc.nextInt();
			chk[b].add(c);
			chk[c].add(b);
		}
		dfs(1);
		int d=0;
		int max=0;
		for(int i=1;i<=a;i++) {
			if(dis[i]>max) {
				max=dis[i];
				d=i;
			}
		}
		Arrays.fill(dis, 0);
		Arrays.fill(vis, false);
		dfs(d);
		Arrays.sort(dis);
		System.out.println(dis[10000]);

	}

}
