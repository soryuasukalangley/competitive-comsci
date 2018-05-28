import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class dmopc17c3p3 {
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
		int a=readInt();
		int[]arr=new int[a];
		for(int i=0;i<a;i++)
			arr[i]=readInt();
		ArrayList<pair>sum=new ArrayList<pair>();
		for(int i=1;i<(1<<a);i++) {
			int j=i,h=0;
			int[] digits=new int[a+1];
			while(j>0) {
				digits[h]=j%2;
				j/=2;
				h++;
			}
			int cursum=0;
			for(int k=0;k<h;k++) {
				if(digits[k]==1)
					cursum+=arr[k];
			}
			sum.add(new pair(cursum,i));
		}
		Collections.sort(sum);
		int num1=0;
		int num2=0;
		int mindif=Integer.MAX_VALUE;
		for(int i=0;i<sum.size()-1;i++) {
			pair p=sum.get(i);
			pair p2=sum.get(i+1);
			if(mindif>p2.a-p.a&&(p2.b&p.b)==0) {
				mindif=p2.a-p.a;
				num1=p.b;
				num2=p2.b;
			}
		}
		int j=num1,h=0;
		int[] digits=new int[a+1];
		while(j>0) {
			digits[h]=j%2;
			j/=2;
			h++;
		}
		for(int i=0;i<digits.length-1;i++) {
			if(digits[i]==1) {
				bw.write(Integer.toString(i+1));
				bw.write(" ");
			}
		}
		bw.newLine();
		j=num2;
		h=0;
		digits=new int[a+1];
		while(j>0) {
			digits[h]=j%2;
			j/=2;
			h++;
		}
		for(int i=0;i<digits.length-1;i++) {
			if(digits[i]==1) {
				bw.write(Integer.toString(i+1));
				bw.write(" ");
			}
		}
		bw.flush();

	}

}
