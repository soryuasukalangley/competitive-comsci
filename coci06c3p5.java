import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class coci06c3p5 {
	static ArrayList<Integer>[]chk;
	static boolean use[];
	static int[]state;
	static ArrayList<Integer>topo;
	static boolean isloop=false;
	
	public static void dfs(int n) {
		state[n]=1;
		if(n==2)
			use[n]=true;
		for(int i:chk[n]) {
			if(state[i]==0) {
				dfs(i);
				if(use[i])use[n]=true;
			}else if(state[i]==2)
				if(use[i])use[n]=true;
		}
		state[n]=2;
	}
	
	public static void dfs2(int n) {
		 state[n]=1;
		 for(int i:chk[n]) {
			 if(use[i]&&state[i]==0)
				 dfs2(i);
			else if(use[i]&&state[i]==1)
				isloop=true;
		 }
		 state[n]=2;
		 topo.add(n);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		chk=new ArrayList[a+1];
		state=new int[a+1];
		use=new boolean[a+1];
		long[] co=new long[a+1];
		topo=new ArrayList<Integer>();
		boolean big=false;
		for(int i=1;i<=a;i++)
			chk[i]=new ArrayList<Integer>();
		for(int i=0;i<b;i++) {
			int c=sc.nextInt();
			int d=sc.nextInt();
			chk[c].add(d);
		}
		dfs(1);
		Arrays.fill(state, 0);
		dfs2(1);
		if(isloop)
			System.out.println("inf");
		else {
			Collections.reverse(topo);
			co[1]=1;
			for(int i:topo) {
				for(int j:chk[i]) {
					if(co[j]+co[i]>=1000000000)big=true;
					co[j]=(co[j]%10000000000L+co[i]%10000000000L)%10000000000L;
				}
			}
			if(big) {
				System.out.printf("%09d%n",co[2]%1000000000);
			}
			else
				System.out.println(co[2]);
		}

	}

}
