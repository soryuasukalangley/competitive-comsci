import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class pursuitofknowledge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		ArrayList<Integer>[] chk=new ArrayList[a+1];
		for(int i=0;i<chk.length;i++) {
			chk[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<b;i++) {
			int d=sc.nextInt();
			int e=sc.nextInt();
			chk[d].add(e);
		}
		int[][]dis=new int[a+1][a+1];
		for (int[] row:dis)
		    Arrays.fill(row,1000000);
		for(int i=1;i<=a;i++) {
			PriorityQueue<Integer> unv=new PriorityQueue<Integer>();
			unv.add(i);
			dis[i][i]=0;
			while(!unv.isEmpty()) {
				int cur=unv.poll();
				for(int j=0;j<chk[cur].size();j++){
					int n=chk[cur].get(j);
					if(dis[i][n]>dis[i][cur]+c){
						dis[i][n]=dis[i][cur]+c;
	                    	unv.add(n);
					}
				}
			}
		}
		int x=sc.nextInt();
		for(int i=0;i<x;i++) {
			int d=sc.nextInt();
			int e=sc.nextInt();
			if(dis[d][e]==1000000)
				System.out.println("Not enough hallways!");
			else
				System.out.println(dis[d][e]);
		}

	}

}
