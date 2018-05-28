import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class mnyc17p3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String[]A=br.readLine().split(" ");
		char[]a=A[0].toCharArray();
		char[]b=A[1].toCharArray();
		long p1=37,p2=1000000007;
		long prmtable[]=new long[Math.max(a.length, b.length)+1];
		prmtable[0]=1;
		for (int i=1;i<=Math.max(a.length, b.length);i++) 
			prmtable[i]=(prmtable[i-1]*p1)%p2;
		long[]presum1=new long[a.length+1];
		long[]presum2=new long[b.length+1];
		for(int i=1;i<=a.length;i++) 
			presum1[i]=((presum1[i-1])+((a[i-1])*prmtable[i-1])%p2)%p2;
		for(int i=1;i<=b.length;i++) 
			presum2[i]=((presum2[i-1])+((b[i-1])*prmtable[i-1])%p2)%p2;
		int num=0;
		int x=Math.min(a.length, b.length);
		for(int i=0;i<=x;i++) {
			long f1=((presum1[a.length]-presum1[a.length-i])%p2+p2)%p2;
			long f2=(presum2[i]*prmtable[a.length-i])%p2;
			if(f1==f2) {
				num=i;
			}
		}
		bw.write(A[0]);
		for(int i=num;i<b.length;i++)
			bw.write(Character.toString(b[i]));
		bw.flush();

	}

}
