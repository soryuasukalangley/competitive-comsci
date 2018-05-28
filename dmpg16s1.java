
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class dmpg16s1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		Stack<Long>s1a=new Stack<Long>();
		Stack<Long>s2a=new Stack<Long>();
		Stack<Long>s1b=new Stack<Long>();
		Stack<Long>s2b=new Stack<Long>();
		int co=0,co2=0;
		for(int i=0;i<a;i++) {
			long b=sc.nextLong();
			s1a.push(b);
			s1b.push(b);
		}
		for(int i=0;i<a;i++) {
			long b=sc.nextLong();
			s2a.push(b);
			s2b.push(b);
		}
		Collections.sort(s1a);
		Collections.sort(s2a);
		Collections.sort(s1b);
		Collections.sort(s2b);
		while(!s2a.isEmpty()) {
			long b=s1a.peek();
			long c=s2a.peek();
			if(b<=c)
				s2a.pop();
			else {
				co++;
				s2a.pop();
				s1a.pop();
			}
		}
		while(!s1b.isEmpty()) {
			long b=s1b.peek();
			long c=s2b.peek();
			if(b>=c)
				s1b.pop();
			else {
				co2++;
				s2b.pop();
				s1b.pop();
			}
		}
		System.out.println(co);
		System.out.println(co2);

	}

}
