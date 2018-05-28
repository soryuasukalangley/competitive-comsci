import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cco17p5 {
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
	
	public static class pair implements Comparable<pair>{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
        public int compareTo(pair x) {
        		return Integer.compare(this.a, x.a);
        }
    }

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<pair>con=new ArrayList<pair>();
		int a=readInt();
		for(int i=0;i<a;i++) {
			int b=readInt();
			int c=readInt();
			con.add(new pair(-b,c));
		}
		Collections.sort(con);
		PriorityQueue<Integer> pt=new PriorityQueue<Integer>();
		int co=0;
		int connected=0;
		for(int i=0;i<a;i++) {
			pt.add(con.get(i).b);
			if(-con.get(i).a>a-(i+1)+connected) {
				connected++;
				co+=pt.poll();
			}
		}
		bw.write(Integer.toString(co));
		bw.close();

	}

}
