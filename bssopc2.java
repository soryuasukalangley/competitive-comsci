import java.util.Arrays;
import java.util.Scanner;

public class bssopc2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int[]imUrFather=new int[a];
		for(int i=0;i<a;i++)
			imUrFather[i]=sc.nextInt();
		Arrays.sort(imUrFather);
		System.out.println(imUrFather[imUrFather.length-2]);

	}

}
