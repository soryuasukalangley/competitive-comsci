import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class anoisyclass {
	static ArrayList<Integer>[] chk;
	static boolean[]vis;
	static boolean loop=false;
	
	public static boolean lop(int x,int y) {
		if(vis[x]==true)
			return true;
		vis[x]=true;
		for(int i=0;i<chk[x].size();i++) {
			int n=chk[x].get(i);
			if(n==y)
				return true;
			if(lop(n,x))
	            return true;
		}
		vis[x]=false;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		chk=new ArrayList[a+1];
		vis=new boolean[a+1];
		PriorityQueue<Integer> unv=new PriorityQueue<Integer>();
		for(int i=0;i<chk.length;i++) {
			chk[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<b;i++) {
			int c=sc.nextInt();
			int d=sc.nextInt();
			chk[c].add(d);
			unv.add(c);
		}
		for(int i:unv){
	        if(lop(i,i))
	           loop=true;
	        if(loop)
	            break;
	    }
		if(!loop) {
			System.out.println("Y");
		}else
			System.out.println("N");

	}

}
