import java.util.Scanner;

public class tle1721 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String A=sc.nextLine();
		int co=0;
		for(int i=0;i<A.length();i++) {
			if(A.charAt(i)!='('&&A.charAt(i)!=')'&&A.charAt(i)!=' '&&A.charAt(i)!='x'&&A.charAt(i)!='r'&&A.charAt(i)!='c') {
				System.out.print("(c"+A.charAt(i)+"r ");
				co++;
			}else if(A.charAt(i)=='x') {
				System.out.print(" x");
			}
		}
		for(int i=0;i<co;i++) {
			System.out.print(")");
		}

	}

}
