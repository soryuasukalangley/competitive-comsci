import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ccc03s3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int xm[]={-1,0,1,0},ym[]={0,-1,0,1};
		char[][]floor=new char[b][c];
		int co=0,co2=0,co3=0;
		int[]rooms=new int[626];
		for(int i=0;i<b;i++) {
			String A=sc.next();
			floor[i]=A.toCharArray();
		}
		LinkedList<Integer> xv=new LinkedList<Integer>();
		LinkedList<Integer> yv=new LinkedList<Integer>();
		for(int i=0;i<b;i++) {
			for(int j=0;j<c;j++) {
				if(floor[i][j]=='.') {
					xv.add(i);
					yv.add(j);
					while(!xv.isEmpty()){
						int x=xv.removeFirst();
						int y=yv.removeFirst();
						co++;
						floor[x][y]='I';
						for(int k=0;k<4;k++){
				            int nx=x+xm[k],ny=y+ym[k];
				            if(nx>=b||nx<0)continue;
				            if(ny>=c||ny<0)continue;
				            if(floor[nx][ny]=='I')continue;
				            xv.add(nx);
				            yv.add(ny);
				            floor[nx][ny]='I';
				        }
					}
				}
				co2++;
				rooms[co2]=co;
				co=0;
			}
		}
		Arrays.sort(rooms);
		for(int i=625;i>=0;i--) {
			if(a-rooms[i]>=0&&rooms[i]!=0) {
				a=a-rooms[i];
				co3++;
			}else break;
		}
		if(co3==1)
			System.out.println(co3+" room, "+a+" square metre(s) left over");
		else
			System.out.println(co3+" rooms, "+a+" square metre(s) left over");

	}

}
