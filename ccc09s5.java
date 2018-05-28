import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ccc09s5 {
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

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int rows=readInt();
		int columns=readInt();
		int c=readInt();
		int[][]dif=new int[rows+1][columns+1];
		for(int i=0;i<c;i++) {
			int colnum=readInt();
			int rownum=readInt();
			int rad=readInt();
			int bit=readInt();
			colnum--;
			rownum--;
			for(int j=Math.max(0, colnum-rad);j<=Math.min(columns-1, rad+colnum);j++) {
				int start=Math.max(0, rownum-(int)Math.sqrt(rad*rad-(colnum-j)*(colnum-j)));
				int end=Math.min(rows-1, rownum+(int)Math.sqrt(rad*rad-(colnum-j)*(colnum-j)));
				dif[start][j]+=bit;
				dif[end+1][j]-=bit;
			}
		}
		int ans=dif[0][0];
		int co=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				if(i>0)
					dif[i][j]+=dif[i-1][j];
				if(dif[i][j]==ans)
					co++;
				if(dif[i][j]>ans) {
					ans=dif[i][j];
					co=1;
				}
			}
		}
		bw.write(Integer.toString(ans));
		bw.newLine();
		bw.write(Integer.toString(co));
		bw.flush();

	}

}
