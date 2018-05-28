import java.util.ArrayList;
import java.util.Scanner;

public class ccc07s4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		ArrayList<Integer>[]chk=new ArrayList[a+1];
		int[]st=new int[a+1];
		for(int i=0;i<chk.length;i++) {
			chk[i]=new ArrayList<Integer>();
		}
		while(true) {
			int b=sc.nextInt();
			int c=sc.nextInt();
			if(b==0&&c==0)break;
			chk[b].add(c);
		}
		st[1]=1;
		for(int i=0;i<=a;i++){
	        for(int j=0;j<chk[i].size();j++){
	            st[chk[i].get(j)]+=st[i];
	        }
	    }
		System.out.println(st[a]);

	}

}
