import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bf4hard {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] A=br.readLine().toCharArray();
		char[] B=br.readLine().toCharArray();
		long p1=37,p2=1000000007;
		long prmtable[]=new long[A.length+2];
		prmtable[0]=1;
		for (int i=1;i<=A.length;i++) {
			prmtable[i]=(prmtable[i-1]*p1)%p2;
		}
		long[]presum=new long[A.length+1];
		for(int i=1;i<=A.length;i++) 
			presum[i]=((presum[i-1])%p2+((A[i-1])*prmtable[i-1])%p2)%p2;
		long str2=0;
		for(int i=0;i<B.length;i++) 
			str2=(str2+(B[i] * prmtable[i])%p2)%p2;
		int ans=-1;
		for(int i=0;i<presum.length-B.length;i++) {
			if (i!=0) {
				str2*=p1;
				str2%=p2;
			}
			if((presum[i+B.length]-presum[i]+p2)%p2==(str2)) {
				ans=i;
				break;
			}
		}
		System.out.println(ans);

	}

}
