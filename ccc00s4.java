import java.util.Arrays;
import java.util.Scanner;

public class ccc00s4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int[]dis=new int[b+1];
		int[]co=new int[a+1];
		for(int i=1;i<=b;i++) {
			dis[i]=sc.nextInt();
		}
		for(int i=1;i<=a;i++) {
			int min=Integer.MAX_VALUE;
			for(int j=1;j<=b;j++) {
				if(i-dis[j]>=0&&co[i-dis[j]]>=0&&co[i-dis[j]]<min)
					min=co[i-dis[j]];
			}
			if(min<Integer.MAX_VALUE)
				co[i]=min+1;
			else
				co[i]=-1;
		}
		if(co[a]==-1)
			System.out.println("Roberta acknowledges defeat.");
		else
			System.out.println("Roberta wins in "+co[a]+" strokes.");

	}

}
