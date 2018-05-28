import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ccc07s3 {
	static ArrayList<Integer>[] chk=new ArrayList[9999+1];;
	static boolean[]vis=new boolean[9999+1];
	static int[]dis=new int[9999+1];
	
	public static void dfs(int n,boolean[]vis,ArrayList<Integer>[] chk,int[]dis) {
		vis[n]=true;
		for(int j=0;j<chk[n].size();j++) {
			int i=chk[n].get(j);
			if(vis[i]==false) {
				dis[i]=dis[n]+1;
				dfs(i,vis,chk,dis);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		for(int i=0;i<chk.length;i++) {
			chk[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<a;i++) {
			int b=sc.nextInt();
			int c=sc.nextInt();
			chk[b].add(c);
		}
		while(true) {
			int b=sc.nextInt();
			int c=sc.nextInt();
			if(b==0&&c==0)break;
			dfs(b,vis,chk,dis);
			if(!vis[c])
				System.out.println("No");
			else if(vis[c]){
				int x=dis[c];
				x--;
				System.out.println("Yes "+x);
			}
			Arrays.fill(vis, false);
			Arrays.fill(dis, 0);
		}

	}

}
