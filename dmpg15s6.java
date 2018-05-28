import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dmpg15s6 {
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
        int a;
        double b;
        pair(int a,double b){
            this.a=a;
            this.b=b;
        }
    }

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> fruit=new HashMap<>();
		int a=readInt();
		int b=readInt();
		int ap=0;
		for(int i=1;i<=a;i++) {
			String A=next();
			fruit.put(A, i);
			if(A.equals("APPLES"))
				ap=i;
		}
		ArrayList<pair>[]chk=new ArrayList[a+1];
		for(int i=1;i<=a;i++) {
			chk[i]=new ArrayList<pair>();
		}
		for(int i=0;i<b;i++) {
			String A=next();
			String B=next();
			double c=readDouble();
			chk[fruit.get(A)].add(new pair(fruit.get(B),c));
		}
		boolean det=false;
		double[]val=new double[a+1];
		double app=1;
		LinkedList<pair>unv=new LinkedList<pair>();
		unv.add(new pair(ap,1));
		while(!unv.isEmpty()) {
			pair p=unv.poll();
			int x=p.a;
			double y=p.b;
			if(x==ap&&y>app&&Math.ceil(y)==y) {
				det=true;
				break;
			}
			for(int i=0;i<chk[x].size();i++) {
				pair p2=chk[x].get(i);
				int m=p2.a;
				double n=p2.b;
				if(n*y>val[m]) {
					val[m]=n*y;
					unv.add(new pair(m,y*n));
				}
			}
		}
		if(det)
			System.out.println("YA");
		else
			System.out.println("NAW");

	}

}
