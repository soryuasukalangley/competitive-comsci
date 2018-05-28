import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class year2016p6 {
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
	
	static int a,b,c;
	static int[][]co;
	static int[]left,right;
	
	public static int min(int a,int b) {
		return a<b?a:b;
	}
	
	public static int dp(int lset,int rset,int lsum,int rsum,int cur) {
		if(lsum==0&&rsum==0) return 0;
	    if(Math.abs(lsum-rsum)>c) return Integer.MAX_VALUE-1000;
	    if(lsum==0||rsum==0) return 1;
	    if(co[lset][rset]!=-1) return co[lset][rset];
	    int ans=Integer.MAX_VALUE,last=Integer.MAX_VALUE,addl=0,addr=0;
	    if (cur==1) 
	    		addl=1;
	    else if (cur==0)
	    		addr=1;
	    else{
	    		addl=1; 
	    		addr=1;
	    	}
	    for(int i=0;i<a;i++)
	    		if((lset&(1<<i))!=0)
	    			ans=min(ans,dp(lset&~(1<<i),rset,lsum-left[i],rsum,0)+addl);
	    last=Math.min(last,ans);
	    ans=Integer.MAX_VALUE;
	    for (int i=0;i<b;i++)
	        if ((rset&(1<<i))!=0)
	            ans=min(ans,dp(lset,rset&~(1<<i),lsum,rsum-right[i],1)+addr);
	    last=min(last,ans);
	    return co[lset][rset]=last;
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		a=readInt();
		b=readInt();
		c=readInt();
		left=new int[a];
		right=new int[b];
		int c=0;
		for(int i=0;i<a;i++) {
			left[i]=readInt();
			c+=left[i];
		}
		for(int i=0;i<b;i++)
			right[i]=readInt();
		co=new int[1<<a][1<<b];
		for(int[]rows:co)
			Arrays.fill(rows, -1);
		bw.write(Integer.toString(dp((1<<a)-1,(1<<b)-1,c,c,2)));
		bw.close();

	}

}
