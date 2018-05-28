import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cco13p3 {
	static ArrayList<Integer>[]chk;
	static boolean[] vis;
	static long[]level,childrenlevel;
	static long maxdis=0,childrenmaxdis=0;
	
	public static void dfs(int n) {
		vis[n]=true;
		level[n]=0;
		childrenlevel[n]=1;
		for(int j=0;j<chk[n].size();j++) {
			int i=chk[n].get(j);
			if(vis[i]==false) {
				dfs(i);
				if (level[n]+level[i]+1>maxdis){
		            maxdis=level[n]+level[i]+1;
		            childrenmaxdis=childrenlevel[n]*childrenlevel[i];
		        }
		        else if (level[n]+level[i]+1==maxdis){
		            childrenmaxdis+=childrenlevel[n]*childrenlevel[i];
		        }
		        if (level[n]<level[i]+1){
		            level[n]=level[i]+1;
		            childrenlevel[n]=childrenlevel[i];
		        }
		        else if (level[n]==level[i]+1) {
		            childrenlevel[n]+=childrenlevel[i];
		        }
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		chk=new ArrayList[a+1];
		vis=new boolean[a+1];
		level=new long[a+1];
		childrenlevel=new long[a+1];
		for(int i=1;i<=a;i++) {
			chk[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<a-1;i++) {
			int b=sc.nextInt();
			int c=sc.nextInt();
			chk[b].add(c);
			chk[c].add(b);
		}
		dfs(1);
		System.out.println(maxdis+1+" "+childrenmaxdis);

	}

}
