import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ccc09j5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean[][]friend=new boolean[50][50];
		friend[1][6] = friend[6][1] = true;
	    friend[2][6] = friend[6][2] = true;
	    friend[3][6] = friend[6][3] = true;
	    friend[4][6] = friend[6][4] = true;
	    friend[5][6] = friend[6][5] = true;
	    friend[7][6] = friend[6][7] = true;
	    friend[3][4] = friend[4][3] = true;
	    friend[3][5] = friend[5][3] = true;
	    friend[3][15] = friend[15][3] = true;
	    friend[4][5] = friend[5][4] = true;
	    friend[7][8] = friend[8][7] = true;
	    friend[8][9] = friend[9][8] = true;
	    friend[9][12] = friend[12][9] = true;
	    friend[9][10] = friend[10][9] = true;
	    friend[10][11] = friend[11][10] = true;
	    friend[11][12] = friend[12][11] = true;
	    friend[12][13] = friend[13][12] = true;
	    friend[13][14] = friend[14][13] = true;
	    friend[13][15] = friend[15][13] = true;
	    friend[16][18] = friend[18][16] = true;
	    friend[16][17] = friend[17][16] = true;
	    friend[17][18] = friend[18][17] = true;
		while(true){
			String x=sc.nextLine();
			if(x.equals("q"))break;
			if(x.equals("i")) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				friend[a][b] = friend[b][a] = true;
				continue;
			}
			if(x.equals("d")) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				friend[a][b] = friend[a][b] = false;
				continue;
			}
			if(x.equals("n")) {
				int a=sc.nextInt();
				int co=0;
				for(int i=1;i<50;i++) {
					if(friend[a][i]==true) {
						co++;
					}
				}
				System.out.println(co);
				continue;
			}
			if(x.equals("f")) {
				int a=sc.nextInt();
				int co=0;
				ArrayList<Integer>aa=new ArrayList<Integer>();
				boolean[]vis=new boolean[50];
				vis[a]=true;
				for(int i=1;i<50;i++) {
					if(friend[a][i]==true) {
						aa.add(i);
						vis[i]=true;
					}
				}
				for(int i=0;i<aa.size();i++) {
					int b=aa.get(i);
					for(int j=1;j<50;j++) {
						if(friend[b][j]==true&&!vis[j]) {
							co++;
							vis[j]=true;
						}
					}
				}
				System.out.println(co);
				continue;
			}
			if(x.equals("s")) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				int[] distco=new int[50];
				Arrays.fill(distco,100000);
				PriorityQueue<Integer> unv=new PriorityQueue<Integer>();
				unv.add(a);
				distco[a]=0;
				while(!unv.isEmpty()) {
					int cur=unv.poll();
					for(int i=1;i<friend[cur].length;i++){
						if(friend[cur][i]==true) {
							if(distco[i]>distco[cur]+1){
								distco[i]=distco[cur]+1;
		                    		unv.add(i);
							}
						}
					}
				}
				if(distco[b]==100000)
					System.out.println("Not connected");
				else
					System.out.println(distco[b]);
			}
		}

	}

}
