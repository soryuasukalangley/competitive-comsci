import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class year2018p1 {
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
		int a=readInt();
		int b=readInt();
		int c=readInt();
		int sec=c%60;
		int addmin=sec/60;
		int min=(addmin+b)%60;
		int addhr=(addmin+b)/60;
		int hr=(a+addhr)%12;
		if(sec>0)
			min=min+1;
		if(min>0)
			hr=hr+1;
		String finalsec=null;
		String finalmin=null;
		String finalhr=null;
		if(sec!=0)
			finalsec=String.format("%02d", 60-sec);
		else
			finalsec=String.format("%02d", 0);
		if(min!=0)
			finalmin=String.format("%02d", 60-min);
		else
			finalmin=String.format("%02d", 0);
		if(hr!=0)
			finalhr=String.format("%02d", 12-hr);
		else
			finalhr=String.format("%02d", 0);
		System.out.println(finalhr+":"+finalmin+":"+finalsec);

	}

}
