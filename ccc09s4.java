import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ccc09s4 {
	static BufferedReader br; 
	static PrintWriter out; 
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
        char a,b;
        pair(char a,char b){
            this.a=a;
            this.b=b;
        }
    }

	public static void main(String[] args) throws Exception {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		int b=readInt();
		char[][]chk=new char[a+1][a+1];
		char[]dis=new char[a+1];
		char[]pen=new char[a+1];
		for(char[] rows:chk)
			Arrays.fill(rows, (char)0);
		for(int i=0;i<b;i++) {
			int c=readInt();
			int d=readInt();
			char e=(char)readInt();
			chk[c][d]=e;
			chk[d][c]=e;
		}
		int c=readInt();
		char big=(char)65535;
		Arrays.fill(pen, big);
		for(int i=0;i<c;i++) {
			int d=readInt();
			char e=(char)readInt();
			pen[d]=e;
		}
		int d=readInt();
		Arrays.fill(dis, big);
		dis[d]=0;
		boolean[]vis=new boolean[a+1];
		int city,small,co2;
		co2=0;
		while (co2<a){
		    small=(int)big;
		    city=1;
		    for (int i=1; i<=a;i++){
		    	if (!vis[i] &&dis[i]<small){
			    small=dis[i];
			    city=i;
		    		}
		    }
		    vis[city]=true;
		    co2++;
		    for (int i=1;i<=a;i++)
			if (chk[city][i]>0&&!vis[i])
			    if (dis[i]>dis[city]+chk[city][i])
			    		dis[i]=(char) (dis[city]+chk[city][i]);
		}
		int min=big;
		int co=0;
		for (int i=1;i<=a;i++){
		    co=dis[i]+pen[i];
		    if (co<min)
		    		min=co;
		}
		System.out.println(min);

	}

}

