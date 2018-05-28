import java.util.Scanner;

public class ccc12s5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int[][]co=new int[a][b];
		boolean[][]chk=new boolean[a][b];
		int c=sc.nextInt();
		for(int i=0;i<c;i++) {
			int d=sc.nextInt();
			int e=sc.nextInt();
			chk[d-1][e-1]=true;
		}
		co[0][0]=1;
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				if(i-1>=0&&!chk[i-1][j])
					co[i][j]+=co[i-1][j];
				if(j-1>=0&&!chk[i][j-1])
					co[i][j]+=co[i][j-1];
			}
		}
		System.out.println(co[a-1][b-1]);

	}

}
