import java.io.BufferedReader;                                                                                             
import java.io.IOException;                                                                                                
import java.io.InputStreamReader;                                                                                          
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;                                                                                                
import java.util.Arrays;                                                                                                   
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;                                                                                          
                                                                                                                           
public class cco11p2 {                                                                                                     
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
	                                                                                                                       
	private static class pair{                                                                                             
        short a,b;                                                                                                           
        pair(short a,short b){                                                                                                 
            this.a=a;                                                                                                      
            this.b=b;                                                                                                      
        }                                                                                                                  
    }                                                                                                                      
                                                                                                                           
	private static class trio{                                                                                             
		short a,b,c;                                                                                                         
        trio(short a,short b,short c){                                                                                           
            this.a=a;                                                                                                      
            this.b=b;                                                                                                      
            this.c=c;                                                                                                      
        }                                                                                                                  
    }                                                                                                                      
                                                                                                                           
	public static void main(String[] args) throws IOException {                                                            
		br=new BufferedReader(new InputStreamReader(System.in));                                                           
		short a=(short)readInt();                                                                                                   
		short b=(short)readInt();                                                                                                   
		short c=(short)readInt();                                                                                                   
		ArrayList<trio>[]chk=new ArrayList[b];                                                                             
		short[][]dis=new short[b][a+1];                                                                                        
		for(int i=0;i<b;i++) {                                                                                             
			chk[i]=new ArrayList<trio>();                                                                                  
		}                                                                                                                  
		for(int i=0;i<c;i++) {                                                                                             
			int d=readInt();                                                                                               
			int e=readInt();                                                                                               
			int f=readInt();                                                                                               
			int g=readInt();                                                                                               
			chk[d].add(new trio((short)e,(short)f,(short)g));                                                                                   
			chk[e].add(new trio((short)d,(short)f,(short)g));                                                                                   
		}
		int min=Integer.MAX_VALUE;  
		for(short[] rows:dis)                                                                                                 
			Arrays.fill(rows, Short.MAX_VALUE);                                                                          
		dis[0][0]=0;                                                                                                       
		Queue<pair> unv=new ArrayDeque<pair>();                                                                       
		unv.offer(new pair((short)0,(short)0));                                                                                            
		while(!unv.isEmpty()) {                                                                                            
			pair p=unv.poll();                                                                                             
			int n=p.a;                                                                                                     
			int m=p.b; 
			if(n==b-1)
				min=Math.min(min, dis[n][m]);
			else {
				for(int i=0;i<chk[n].size();i++) {                                                                             
					trio t=chk[n].get(i);                                                                                      
					int x=t.a;                                                                                                 
					int y=t.b;                                                                                                 
					int z=t.c;                                                                                                 
					if(z==1) {                                                                                                 
						if(m+y<=a&&dis[n][m]+y<dis[x][m+y]) {                                                                  
							dis[x][m+y]=(short) (dis[n][m]+y);                                                                           
							unv.offer(new pair((short)x,(short)(m+y)));                                                                          
						}                                                                                                      
					}else if(z==0&&dis[n][m]+y<dis[x][m]) {                                                                    
						dis[x][m]=(short) (dis[n][m]+y);                                                                                 
						unv.offer(new pair((short)x,(short)m));                                                                                
					}   
				}
			}                                                                                                              
		}                                                                                                                                                                                                                                                                                                                           
		if(min!=Integer.MAX_VALUE)                                                                                         
			System.out.println(min);                                                                                       
		else                                                                                                               
			System.out.println(-1);                                                                                        
                                                                                                                           
	}                                                                                                                      
                                                                                                                           
}