
import java.util.Scanner;
public class ccc15j5 {
	static int[][][]co;
	public static int find(int a,int b,int c) {
		if(co[a][b][c]!=0)return co[a][b][c];
		int co2=0;
		if(a<b)return 0;
		else if(a<c)return 0;
		else if(a==b)return 1;
		else if(b==1)return 1;
		for(int i=c;i<=a/b;i++)
			co2+=find(a-i,b-1,i);
		return co[a][b][c]=co2;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		co=new int[a+1][a+1][a+1];
		System.out.println(find(a,b,1));

	}

}
