import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class dmpg15s5 {
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
	
	public static void change(int a,int b,boolean[][]c) {
		if(c[a][b])
			c[a][b]=false;
		else
			c[a][b]=true;
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		int b=readInt();
		boolean[][]dif=new boolean[a+1][a+1];
		boolean[][]ori=new boolean[a+1][a+1];
		for(int i=0;i<b;i++) {
			int c=readInt();
			int d=readInt();
			int e=readInt();
			int f=readInt();
			change(c,d,dif);
			change(c+e,d,dif);
			change(c,d+f,dif);
			change(c+e,d+f,dif);
		}
		ori[0][0]=dif[0][0];
		int co=0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				if(i==0&&j==0) {
					if(ori[i][j])
						co++;
					continue;
				}
				if(i==0)
					ori[i][j]=dif[i][j]^ori[i][j-1];
				else if(j==0)
					ori[i][j]=dif[i][j]^ori[i-1][j];
				else
					ori[i][j]=dif[i][j]^ori[i-1][j]^ori[i][j-1]^ori[i-1][j-1];
				if(ori[i][j])
					co++;
			}
		}
		bw.write(Integer.toString(co));
		bw.flush();

	}

}
