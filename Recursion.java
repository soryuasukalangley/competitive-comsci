import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*	Martin Xu
 *  Feb 25 2018
 *  Recusion Exercise
 *  
 */

public class Recursion {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a=sc.nextInt();
		int b=hanoiMoves(a)-1;

	}

	public static int hanoiMoves(int height) {
		if(height==0)
			return 1;
		return 2*hanoiMoves(height-1);
	}
	
	public static int fib(int num) {
		if(num==0)
			return 0;
		if(num==1)
			return 1;
		return fib(num-1)+fib(num-2);
	}
	
	public static int addup(int idx,int[]arr) {
		if(idx==-1)
			return 0;
		return arr[idx]+addup(idx-1,arr);
	}
	
	public static int sumDigits(int n) {
		if(n==0)
			return 0;
		return n%10+sumDigits(n/10);
	}

}
