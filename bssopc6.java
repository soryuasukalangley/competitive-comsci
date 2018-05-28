import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bssopc6 {
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
	
	public static class quartet {
		int a, b, c, d;
		quartet(int a,int b,int c,int d){
			this.a=a;
			this.b=b;
			this.c=c;
			this.d=d;
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		quartet[]lol=new quartet[a];
		for(int i=0;i<a;i++) {
			int x=readInt();
			int y=readInt();
			int xl=readInt();
			int yl=readInt();
			lol[i]=new quartet(x,y,xl,yl);
		}
		int px=readInt();
		int py=readInt();
		for(int i=a-1;i>=0;i--) {
			int x=lol[i].a;
			int y=lol[i].b;
			int xl=lol[i].c;
			int yl=lol[i].d;
			if(px>=x&&py>=y&&px<=(x+xl)&&py<=(y+yl)) {
				System.out.println(i+1);
				break;
			}
		}

	}

}
