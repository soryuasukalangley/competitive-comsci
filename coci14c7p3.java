import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class coci14c7p3 {
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
	
	static int a,x,big=100000000;
	static int[][]guess,co;
	static int[][]seq={{0,1,2},{0,2,1},{1,2,0},{1,0,2},{2,0,1},{2,1,0}};
	public static int dp(int guy,int problemnum) {
		if (problemnum==a&&guy!=2)
			return big;
	    if (guy>2)
	    		return big;
	    if (co[guy][problemnum]!=-1)
	    		return co[guy][problemnum];
	    return co[guy][problemnum]=guess[seq[x][guy]][problemnum]+Math.min(dp(guy+1,problemnum+1),dp(guy, problemnum+1));
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in)); 
		a=readInt();
		guess=new int[3][a+1];
		co=new int[3][a+1];
		for(int i=0;i<3;i++) {
			for(int j=1;j<=a;j++) {
				guess[i][j]=readInt();
			}
		}
		int best=big;
		int ans=big;
		for(x=0;x<6;x++) {
			for(int[]rows:co)
				Arrays.fill(rows, -1);
			co[0][a]=guess[seq[x][0]][a];
			co[1][a]=guess[seq[x][1]][a];
			co[2][a]=guess[seq[x][2]][a];
			ans=Math.min(ans, dp(0,1));
	        	best=Math.min(best, ans);
		}
		System.out.println(best);
	}

}
