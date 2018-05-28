import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc18s3 {
	static BufferedReader br; 
	static StringTokenizer st; 
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong () throws IOException {
		return Long.parseLong(next());
	}

	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter () throws IOException {
		return next().charAt(0);
	}

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
	
	public static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		int b=readInt();
		char[][]map=new char[a][b];
		int[]xm={1,-1,0,0},ym= {0,0,1,-1};
		int[][]dis=new int[a][b];
		for(int[]arr:dis)
			Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i=0;i<a;i++)
			map[i]=readLine().toCharArray();
		ArrayDeque<pair> unv=new ArrayDeque<pair>();
		boolean det=false;
		for(int i=1;i<a-1;i++) {
			for(int j=1;j<b-1;j++) {
				if(map[i][j]=='S') {
					unv.offer(new pair(i,j));
					dis[i][j]=0;
				}else if(map[i][j]=='C') {
					for(int k=i;k<a-1;k++) {
						if(map[k][j]=='.')
							map[k][j]='X';
						if((map[k][j]=='W'))
							break;
						if((map[k][j]=='S'))
							det=true;
					}
					for(int k=i;k>0;k--) {
						if(map[k][j]=='.')
							map[k][j]='X';
						if((map[k][j]=='W'))
							break;
						if((map[k][j]=='S'))
							det=true;
					}
					for(int k=j;k<b-1;k++) {
						if(map[i][k]=='.')
							map[i][k]='X';
						if(map[i][k]=='W')
							break;
						if((map[i][k]=='S'))
							det=true;
					}
					for(int k=j;k>0;k--) {
						if(map[i][k]=='.')
							map[i][k]='X';
						if(map[i][k]=='W')
							break;
						if((map[i][k]=='S'))
							det=true;
					}
				}
			}
		}
		if(det) {
			for(int i=1;i<a-1;i++) {
				for(int j=1;j<b-1;j++) {
					if(map[i][j]=='.'||map[i][j]=='X') {
						bw.write(Integer.toString(-1));
						bw.newLine();
					}
				}
			}
			bw.flush();
			return;
		}
		while(!unv.isEmpty()) {
			pair p=unv.poll();
			int x=p.a;
			int y=p.b;
			if(map[x][y]=='L') {
				int nx=x;
				int ny=y-1;
				if(map[nx][ny]=='W'||map[nx][ny]=='X'||map[nx][ny]=='C')
					continue;
				if(dis[nx][ny]>dis[x][y]) {
					unv.offer(new pair(nx,ny));
					dis[nx][ny]=dis[x][y];
				}
			}
			else if(map[x][y]=='R') {
				int nx=x;
				int ny=y+1;
				if(map[nx][ny]=='W'||map[nx][ny]=='X'||map[nx][ny]=='C')
					continue;
				if(dis[nx][ny]>dis[x][y]) {
					unv.offer(new pair(nx,ny));
					dis[nx][ny]=dis[x][y];
				}
			}
			else if(map[x][y]=='U') {
				int nx=x-1;
				int ny=y;
				if(map[nx][ny]=='W'||map[nx][ny]=='X'||map[nx][ny]=='C')
					continue;
				if(dis[nx][ny]>dis[x][y]) {
					unv.offer(new pair(nx,ny));
					dis[nx][ny]=dis[x][y];
				}
			}
			else if(map[x][y]=='D') {
				int nx=x+1;
				int ny=y;
				if(map[nx][ny]=='W'||map[nx][ny]=='X'||map[nx][ny]=='C')
					continue;
				if(dis[nx][ny]>dis[x][y]) {
					unv.offer(new pair(nx,ny));
					dis[nx][ny]=dis[x][y];
				}
			}
			else {
				for(int i=0;i<4;i++) {
					int nx=x+xm[i];
					int ny=y+ym[i];
					if(map[nx][ny]=='W'||map[nx][ny]=='X'||map[nx][ny]=='C')
						continue;
					if(dis[nx][ny]>dis[x][y]+1) {
						unv.offer(new pair(nx,ny));
						dis[nx][ny]=dis[x][y]+1;
					}
				}
			}
		}
		for(int i=1;i<a-1;i++) {
			for(int j=1;j<b-1;j++) {
				if(map[i][j]=='.'||map[i][j]=='X') {
					if(dis[i][j]!=Integer.MAX_VALUE) {
						bw.write(Integer.toString(dis[i][j]));
						bw.newLine();
					}
					else {
						bw.write(Integer.toString(-1));
						bw.newLine();
					}
				}
			}
		}
		bw.flush();

	}

}
