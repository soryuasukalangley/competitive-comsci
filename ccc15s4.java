import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ccc15s4 {
	public static class trio{
        int a,b,c;
        trio(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
	
	public static class pair{
        int x,y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		ArrayList<trio>[]chk=new ArrayList[b+1];
		for(int i=0;i<chk.length;i++) {
			chk[i]=new ArrayList<trio>();
		}
		for(int i=0;i<c;i++) {
			int d=sc.nextInt();
			int e=sc.nextInt();
			int f=sc.nextInt();
			int g=sc.nextInt();
			chk[d].add(new trio(e,f,g));
			chk[e].add(new trio(d,f,g));
		}
		int d=sc.nextInt();
		int e=sc.nextInt();
		int big=100000000;
		int[][]dis=new int[b+1][a];
		for(int[]rows:dis)
			Arrays.fill(rows, big);
		dis[d][0]=0;
		LinkedList<pair> unv=new LinkedList<pair>();
		unv.add(new pair(d,0));
		while(!unv.isEmpty()) {
			pair cur=unv.poll();
			int n=cur.x;
			int m=cur.y;
			for(int i=0;i<chk[n].size();i++){
				trio t=chk[n].get(i);
				int x=t.a;
				int y=t.b;
				int z=t.c;
				if(m+z<a&&dis[x][m+z]>dis[n][m]+y){
					dis[x][m+z]=dis[n][m]+y;
					unv.add(new pair(x,m+z));
				}
			}
		}
		int max=big;
		for(int i=0;i<a;i++) {
			if(max>dis[e][i])
				max=dis[e][i];
		}
		if(max==big)
			System.out.println(-1);
		else
			System.out.println(max);

	}

}
