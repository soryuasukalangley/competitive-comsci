import java.util.HashMap;
import java.util.Scanner;

public class tle17c3p2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		HashMap<Integer, Integer> pos=new HashMap<Integer, Integer>();
		int[]pre=new int[b+1];
		long co=0;
		for(int i=1;i<=a;i++) {
			pos.put(sc.nextInt(), i);
		}
		pre[1]=sc.nextInt();
		for(int i=2;i<=b;i++) {
			pre[i]=sc.nextInt();
			co+=Math.abs(pos.get(pre[i])-pos.get(pre[i-1]));
		}
		System.out.println(co+1);

	}

}
