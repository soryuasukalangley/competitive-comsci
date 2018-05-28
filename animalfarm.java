import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class animalfarm {
	static int par[];
	static ArrayList<trio>nodes=new ArrayList<trio>();
	
	public static class trio implements Comparable <trio>{
        int a,b,c;
        trio(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
        public int compareTo (trio x){
			if(this.c<x.c) return -1;
			else return 1;
		}
    }
	
	public static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
	
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
		par=new int[1001];
		pair[][]added=new pair[1001][1001];
		for(int i=0;i<=1000;i++)
			par[i]=i;
		for(int i=1;i<=a;i++) {
			int b=sc.nextInt();
			int[]pen=new int[b];
			int[]val=new int[b];
			for(int j=0;j<b;j++)
				pen[j]=sc.nextInt();
			for(int j=0;j<b;j++)
				val[j]=sc.nextInt();
			for(int j=0;j<b-1;j++) {
				if(added[pen[j]][pen[j+1]]==null) {
					added[pen[j]][pen[j+1]]=added[pen[j+1]][pen[j]]=new pair(i,val[j]);
				}else {
					nodes.add(new trio(i,added[pen[j]][pen[j+1]].a,val[j]));
					added[pen[j]][pen[j+1]]=added[pen[j+1]][pen[j]]=null;
				}
			}
			if(added[pen[0]][pen[b-1]]==null) {
				added[pen[0]][pen[b-1]]=added[pen[b-1]][pen[0]]=new pair(i,val[b-1]);
			}else {
				nodes.add(new trio(i,added[pen[0]][pen[b-1]].a,val[b-1]));
				added[pen[0]][pen[b-1]]=added[pen[b-1]][pen[0]]=null;
			}
		}
		ArrayList<trio>chk=(ArrayList<trio>) nodes.clone();
		Collections.sort(chk);
		int co=0,co2=0,isclosed=0;
		for(int i=0;i<chk.size();i++) {
			trio t=chk.get(i);
			if(find(t.a)!=find(t.b)) {
				co+=t.c;
				un(t.a,t.b);
				isclosed++;
			}
			if(isclosed==a)break;
		}
		for(int i=0;i<=1000;i++)
			par[i]=i;
		for(int i=1;i<=1000;i++) {
			for(int j=1;j<=1000;j++) {
				if(added[i][j]!=null) {
					nodes.add(new trio(0,added[i][j].a,added[i][j].b));
					added[i][j]=added[j][i]=null;
				}
			}
		}
		isclosed=0;
		Collections.sort(nodes);
		for(int i=0;i<nodes.size();i++) {
			trio t=nodes.get(i);
			if(find(t.a)!=find(t.b)) {
				co2+=t.c;
				un(t.a,t.b);
				isclosed++;
			}
			if(isclosed==a)break;
		}
		System.out.println(Math.min(co, co2));

	}

}
