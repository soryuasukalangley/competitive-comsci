import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class gfssoc1s4 {
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
	
	static int a;
	static long[][][]bit=new long[251][251][251];
	
	public static void update (int i,int j,int k,long v){
		int i2=i;
		while (i2<a){
			int j2=j;
			while(j2<a){
				int k2=k;
				while(k2<a) {
					bit[i2][j2][k2]+=v;
					k2+=(k2&(-k2));
				}
				j2+=(j2&(-j2));
			}
			i2+=(i2&(-i2));
		}
	}
	
	public static long query(int i,int j,int k){
		long ans=0;
		int i2=i;
		while (i2>0){
			int j2=j;
			while(j2>0){
				int k2=k;
				while(k2>0) {
					ans+=bit[i2][j2][k2];
					k2-=(k2&(-k2));
				}
				j2-=(j2&(-j2));
			}
			i2-=(i2&(-i2));
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		a=readInt()+1;
		long co=0;
		int b=readInt();
		for(int i=0;i<b;i++) {
			String s=next();
			if(s.equals("C")) {
				int x=readInt();
				int y=readInt();
				int z=readInt();
				long v=readInt();
				long less=(query(x,y,z)-query(x-1,y,z)-query(x,y-1,z)-query(x,y,z-1)+query(x-1,y-1,z)+query(x,y-1,z-1)+query(x-1,y,z-1)-query(x-1,y-1,z-1));
				update(x,y,z,v-less);
			}else {
				int x=readInt();
				int y=readInt();
				int z=readInt();
				int x2=readInt();
				int y2=readInt();
				int z2=readInt();
				co+=(query(x2,y2,z2)-query(x-1,y2,z2)-query(x2,y-1,z2)-query(x2,y2,z-1)+query(x-1,y-1,z2)+query(x2,y-1,z-1)+query(x-1,y2,z-1)-query(x-1,y-1,z-1));
			}
		}
		bw.write(Long.toString(co));
		bw.flush();

	}

}
