import java.util.LinkedList;
import java.util.Scanner;

public class ccc10j5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		int xm[]={1, -1, 2, 2, 1, -1, -2, -2},ym[]={-2, -2, -1, 1, 2, 2, -1, 1};
		int[][]v=new int[9][9];
		LinkedList<Integer> xv=new LinkedList<Integer>();
		LinkedList<Integer> yv=new LinkedList<Integer>();
		LinkedList<Integer> co=new LinkedList<Integer>();
		xv.add(a);
		yv.add(b);
		co.add(0);
		while(!xv.isEmpty()){
			int x=xv.removeFirst();
			int y=yv.removeFirst();
			int con=co.removeFirst();
			if(x==c&&y==d){
	            System.out.println(con);
	            break;
	        }
			for(int i=0;i<8;i++){
	            int nx=x+xm[i],ny=y+ym[i];
	            if(nx<=8&&nx>=1&&ny<=8&&ny>=1){
	                xv.add(nx);
	                yv.add(ny);
	                co.add(con+1);
	            }
	        }
		}

	}

}
