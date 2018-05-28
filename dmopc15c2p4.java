import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dmopc15c2p4 {
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
	
	static long[]retime,dura,hap,co;
	static int a;
	
	public static long dp(int min) {
		if (min>a)
			return 0;
	    if (co[min]!=0) 
	    		return co[min];
	    int mini=min+1,maxi=a, mid;
	    while (mini<=maxi){
	        mid=(maxi+mini)/2;
	        if(retime[mid]<retime[min]+dura[min])
	            mini=mid+1;
	        else
	            maxi= mid-1;
	    }
	    if(mini==min)return co[min]=Math.max(dp(min+1), hap[min]);
	    return co[min]=Math.max(co[min], Math.max(dp(min+1), dp(mini)+hap[min]));
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in)); 
		a=readInt();
		retime=new long[a+1];
		dura=new long[a+1];
		hap=new long[a+1];
		co=new long[a+1];
		for(int i=1;i<=a;i++) {
			retime[i]=readLong();
			dura[i]=readLong();
			hap[i]=readLong();
		}
		System.out.println(dp(1));

	}

}
