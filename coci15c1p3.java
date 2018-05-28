import java.util.Scanner;

public class coci15c1p3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int c=sc.nextInt();
		int b=sc.nextInt();
		String[] app=new String[a];
		int[]val=new int[a];
		int[]cos=new int[a];
		int[]vol=new int[a];
		int[][]co=new int[b+1][c+1];
		int[][][]co2=new int[b+1][c+1][a];
		for(int i=0;i<a;i++) {
			app[i]=sc.next();
			val[i]=sc.nextInt();
			cos[i]=sc.nextInt();
			vol[i]=sc.nextInt();
		}
		for(int i=0;i<=c;i++) {
			for(int j=0;j<=b;j++) {
				for(int k=0;k<a;k++) {
					if(vol[k]<=j&&cos[k]<=i) {
						if(co[j][i]<co[j-vol[k]][i-cos[k]]+val[k]) {
							co[j][i]=co[j-vol[k]][i-cos[k]]+val[k];
							for(int jk=0;jk<a;jk++) {
								co2[j][i][jk]=co2[j-vol[k]][i-cos[k]][jk];
							}
							co2[j][i][k]++;
						}
					}
				}
			}
		}
		System.out.println(co[b][c]);
		for(int i=0;i<a;i++){
			System.out.println(app[i]+" "+co2[b][c][i]);
		}

	}

}
