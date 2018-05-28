import java.util.Scanner;

public class ds2 {
	static int par[];
	public static int find(int n) {
		if(n!=par[n])par[n]=find(par[n]);
		return par[n];
	}
	
	public static void un(int a,int b) {
		par[find(a)]=find(b);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		par=new int[a+1];
		boolean[] chk=new boolean[b+1];
		for(int i=0;i<=a;i++) {
			par[i]=i;
		}
		for(int i=1;i<=b;i++) {
			int c=sc.nextInt();
			int d=sc.nextInt();
			if(find(c)!=find(d)){
				un(c,d);
				chk[i]=true;
			}
		}
		int co=0;
		for(int i=1;i<=b;i++){
			if(chk[i])
				co++;
		}
		if(co<a-1)
			System.out.println("Disconnected Graph");
		else {
			for(int i=1;i<=b;i++){
				if(chk[i])
					System.out.println(i);
			}
		}

	}

}
