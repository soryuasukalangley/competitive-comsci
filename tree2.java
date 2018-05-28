import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class tree2 {
	private static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
	
	public static int cal(int a, int b,int c,int d) {
		return (a-c)*(a-c)+(b-d)*(b-d);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]in=br.readLine().split(" ");
		int a=Integer.parseInt(in[0]);
		int b=Integer.parseInt(in[1]);
		int[]xm={1,-1,0,0},ym={0,0,1,-1};
		int[][]map=new int[a][b],dis=new int[a][b],tree=new int[a][b];
		int max=0,start1=0,start2=0,end1=0,end2=0;
		for(int i=0;i<a;i++) {
			in=br.readLine().split(" ");
			for(int j=0;j<b;j++) {
				if(in[j].equals("1"))
					map[i][j]=1;
				else if(in[j].equals("2"))
					map[i][j]=2;
				else if(in[j].equals("3"))
					map[i][j]=3;
				else if(in[j].equals("4"))
					map[i][j]=4;
				else if(in[j].equals("5"))
					map[i][j]=5;
				else if(in[j].equals("6"))
					map[i][j]=6;
				else if(in[j].equals("7"))
					map[i][j]=7;
				else if(in[j].equals("8"))
					map[i][j]=8;
				else if(in[j].equals("9"))
					map[i][j]=9;
				else if(in[j].equals("."))
					map[i][j]=0;
				else if(in[j].equals("X")) {
					map[i][j]=0;
					start1=i;
					start2=j;
				}
				if(map[i][j]>max) {
					max=map[i][j];
				}
			}
		}
		int mdis=Integer.MAX_VALUE;
		for (int i=0;i<a;i++){
	        for (int j=0;j<b;j++) {
	        		if(map[i][j]==max&&mdis>cal(i,j,start1,start2)) {
	        			mdis=cal(i,j,start1,start2);
	        			end1=i;
	        			end2=j;
	        		}
	        }
	    }
		Queue<pair> unv=new ArrayDeque<pair>();
		unv.offer(new pair(start1,start2));
		for(int[]row: dis)
			Arrays.fill(row, Integer.MAX_VALUE);
		for(int[]row: tree)
			Arrays.fill(row, Integer.MAX_VALUE);
		dis[start1][start2]=0;
		tree[start1][start2]=0;
		while(!unv.isEmpty()) {
			pair p=unv.poll();
			int x=p.a;
			int y=p.b;
			for(int i=0;i<4;i++) {
				int nx=x+xm[i],ny=y+ym[i];
	            if(nx>=a||nx<0)continue;
	            if(ny>=b||ny<0)continue;
	            if(dis[nx][ny]<dis[x][y]+map[nx][ny])continue;
	            int tr=0;
	            if(map[nx][ny]>0)
	            		tr=1;
	            if(dis[nx][ny]==dis[x][y]+map[nx][ny]&&tree[nx][ny]<=tree[x][y]+tr)continue;
	            	dis[nx][ny]=dis[x][y]+map[nx][ny];
	            	tree[nx][ny]=tree[x][y]+tr;
	            	unv.offer(new pair(nx,ny));
			}
		}
		System.out.println(tree[end1][end2]-1);

	}

}
