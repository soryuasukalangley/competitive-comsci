import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ccoprep16q1 {
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
	
	private static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int a=readInt();
		for(int i=0;i<a;i++) {
			int b=readInt();
			int c=readInt();
			char[][]map=new char[b][c];
			pair[]rec=new pair[c];
			for(int j=0;j<b;j++) {
				for(int k=0;k<c;k++)
					map[j][k]=readCharacter();
			}
			int[]maxlengthbuilt=new int[c];
			int max=0;
			for(int j=0;j<b;j++) {
				int t=-1;
				for(int k=0;k<c;k++) {
					if(map[j][k]=='R') {
						maxlengthbuilt[k]=0;
						t=-1;
					}else {
						maxlengthbuilt[k]++;
						pair p=new pair(k,maxlengthbuilt[k]);
						if(t==-1) 
							rec[++t]=p;
						else {
							while(t>=0&&rec[t].b>=p.b)
								p.a=rec[t--].a;
							rec[++t]=p;
						}
						for(int l=0;l<=t;l++) 
							max=Math.max(max, rec[l].b*(k-rec[l].a+1));
					}
				}
			}
			System.out.println(max*3);
		}

	}

}
