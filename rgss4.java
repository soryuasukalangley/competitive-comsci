import java.util.Scanner;

public class rgss4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int[]h=new int[a];
		int[]co=new int[a];
		int ans=0;
		for(int i=0;i<a;i++) {
			h[i]=sc.nextInt();
		}
		for(int i=0;i<a;i++){
			co[i]=0;
			for(int j=0;j<i;j++){
				if(h[j]<h[i]){
					co[i]=Math.max(co[i], co[j]);
				}
			}
			co[i]+=h[i];
		}
		for(int i=0;i<a;i++){
			ans=Math.max(ans, co[i]);
		}
		System.out.println(ans);

	}

}
