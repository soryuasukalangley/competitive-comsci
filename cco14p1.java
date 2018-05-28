import java.util.Arrays;
import java.util.Scanner;

public class cco14p1 {
	static char[][]tri;
	static int chang;
	static int[][]mem;
	public static int numtri(int a, int b) {
		int co2=0;
		if(tri[a][b]=='.')return 0;
		if(mem[a][b]!=0)return mem[a][b];
		if(b-1>=0&&b+1<chang&&a+1<chang)
			co2=Math.min(Math.min(numtri(a+1,b-1), numtri(a+1,b)), numtri(a+1,b+1));
		return mem[a][b]=co2+1;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		chang=sc.nextInt();
		tri=new char[chang][chang];
		mem=new int[chang][chang];
		for(int i=0;i<chang;i++) {
			String A=sc.next();
			tri[i]=A.toCharArray();
		}
		int co=0;
		for(int i=chang-1;i>=0;i--) {
			for(int j=0;j<chang;j++) {
				if(tri[i][j]=='#') {
					co+=numtri(i,j);
				}
			}
		}
		System.out.println(co);

	}

}
