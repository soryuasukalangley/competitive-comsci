import java.util.Scanner;

public class dmopc14c3p6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int[][]pre=new int[a+1][3];
		int[][]val=new int[a+1][3];
		int[][]co=new int[2][b+1];
		for(int i=1;i<=a;i++) {
			pre[i][0]=sc.nextInt();
			val[i][0]=sc.nextInt();
			pre[i][1]=sc.nextInt();
			val[i][1]=sc.nextInt();
			pre[i][2]=sc.nextInt();
			val[i][2]=sc.nextInt();
		}
		int place=0;
		for(int i=1;i<=a;i++) {
			for(int j=0;j<=b;j++) {
				if(pre[i][0]<=j) 
					co[place][j]=Math.max(co[1-place][j], co[1-place][j-pre[i][0]]+val[i][0]);
				if(pre[i][1]<=j) 
					co[place][j]=Math.max(co[place][j], co[1-place][j-pre[i][1]]+val[i][1]);
				if(pre[i][2]<=j) 
					co[place][j]=Math.max(co[place][j], co[1-place][j-pre[i][2]]+val[i][2]);
				if(pre[i][0]>j)
					co[place][j]=co[1-place][j];
			}
			place=1-place;
		}
		int max=0;
		for(int i=0;i<=b;i++) {
			max=Math.max(max, co[1-place][i]);
		}
		System.out.println(max);

	}

}
