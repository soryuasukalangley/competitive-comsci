import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dmopc14c1p5 {
	private static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int start1=sc.nextInt();
		int start2=sc.nextInt();
		int end1=sc.nextInt();
		int end2=sc.nextInt();
		char[][]map=new char[a][b];
		int[][]dis=new int[a][b];
		for(int i=0;i<a;i++)
			map[i]=sc.next().toCharArray();
		int c=sc.nextInt();
		ArrayList<pair>tele=new ArrayList<pair>();
		for(int i=0;i<c;i++) {
			int d=sc.nextInt();
			int e=sc.nextInt();
			tele.add(new pair(d,e));
		}
		int xm[]={-1,0,1,0},ym[]={0,-1,0,1};
		for(int[]rows:dis)
			Arrays.fill(rows, Integer.MAX_VALUE);
		dis[start1][start2]=0;
		ArrayDeque<pair>unv=new ArrayDeque<pair>();
		unv.add(new pair(start1,start2));
		while(!unv.isEmpty()) {
			pair p=unv.poll();
			int x=p.a;
			int y=p.b;
			for(int i=0;i<4;i++){
	            int nx=x+xm[i],ny=y+ym[i];
	            if(nx<a&&nx>=0&&ny<b&&ny>=0&&map[nx][ny]!='X'){
	            		if(dis[x][y]+1<dis[nx][ny]) {
	            			dis[nx][ny]=dis[x][y]+1;
	            			unv.add(new pair(nx,ny));
	            		}
	            }
			}
		}
		int mindis=Integer.MAX_VALUE;
		for(int i=0;i<tele.size();i++) {
			pair p=tele.get(i);
			mindis=Math.min(mindis, dis[p.a][p.b]);
		}
		if(dis[end1][end2]-mindis<0)
			System.out.println(dis[end1][end2]);
		else
			System.out.println(dis[end1][end2]-mindis);

	}

}
