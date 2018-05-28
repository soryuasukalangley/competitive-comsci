import java.util.LinkedList;
import java.util.Scanner;

public class ccc08s3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int xm[]={1,-1,0,0},ym[]={0,0,1,-1};
		int xm2[]={0,0},ym2[]={1,-1};
		int xm3[]={1,-1},ym3[]={0,0};
		for(int i=0;i<a;i++) {
			int b=sc.nextInt();
			int c=sc.nextInt();
			char[][]map=new char[b][c];
			for(int j=0;j<b;j++) {
				String A=sc.next();
				map[j]=A.toCharArray();
			}
			LinkedList<Integer> xv=new LinkedList<Integer>();
			LinkedList<Integer> yv=new LinkedList<Integer>();
			LinkedList<Integer> co=new LinkedList<Integer>();
			boolean chk=false;
			boolean[][]vis=new boolean[b+1][c+1];
			xv.add(1);
			yv.add(1);
			co.add(0);
			while(!xv.isEmpty()){
				int x=xv.removeFirst();
				int y=yv.removeFirst();
				int con=co.removeFirst();
				if(x==b&&y==c){
		            System.out.println(con+1);
		            chk=true;
		            break;
		        }
				char place=map[x-1][y-1];
				if(place=='+') {
					for(int k=0;k<4;k++){
			            int nx=x+xm[k],ny=y+ym[k];
			            if(nx>b||nx<1)continue;
			            if(ny>c||ny<1)continue;
			            if(map[nx-1][ny-1]=='*')continue;
			            if(vis[nx][ny]==true)continue;
			            xv.add(nx);
			            yv.add(ny);
			            co.add(con+1);
			            vis[nx][ny]=true;
			        }
				}else if(place=='-') {
					for(int k=0;k<xm2.length;k++){
			            int nx=x+xm2[k],ny=y+ym2[k];
			            if(nx>b||nx<1)continue;
			            if(ny>c||ny<1)continue;
			            if(map[nx-1][ny-1]=='*')continue;
			            if(vis[nx][ny]==true)continue;
			            xv.add(nx);
			            yv.add(ny);
			            co.add(con+1);
			            vis[nx][ny]=true;
			        }
				}else if(place=='|') {
					for(int k=0;k<xm3.length;k++){
			            int nx=x+xm3[k],ny=y+ym3[k];
			            if(nx>b||nx<1)continue;
			            if(ny>c||ny<1)continue;
			            if(map[nx-1][ny-1]=='*')continue;
			            if(vis[nx][ny]==true)continue;
			            xv.add(nx);
			            yv.add(ny);
			            co.add(con+1);
			            vis[nx][ny]=true;
			        }
				}
			}
			if(chk==false)
				System.out.println(-1);
		}

	}

}
