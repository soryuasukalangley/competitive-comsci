import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class cco10p6 {
	static char[]change;
	static HashMap<Character,Character>conv;
	static ArrayList<String>allres;
	public static void change() {
		for(int i=0;i<change.length;i++) {
			change[i]=conv.get(change[i]);
		}
		String x=new String(change);
		allres.add(x);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		conv=new HashMap<Character,Character>();
		allres=new ArrayList<String>();
		for(int i=65;i<=90;i++) {
			String A=sc.next();
			char x=A.charAt(0);
			conv.put((char)i, x);
		}
		String A=sc.next();
		char x=A.charAt(0);
		conv.put('_', x);
		int a=sc.nextInt();
		String B=sc.next();
		change=B.toCharArray();
		change();
		int co=1;
		while(true) {
			String C=new String(change);
			if(C.equals(B))break;
			co++;
			change();
		}
		System.out.println(allres.get(a%co-1));

	}

}
