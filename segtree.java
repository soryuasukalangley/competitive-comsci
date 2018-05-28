import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class segtree {
	static BufferedReader br; 
	static StringTokenizer st; 
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong () throws IOException {
		return Long.parseLong(next());
	}

	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter () throws IOException {
		return next().charAt(0);
	}

	static String readLine () throws IOException {
		return br.readLine().trim();
	}
	
	static int[] ori;
	static node[] segTree=new node[300000];
	
	public static class node{
		int l;int r;int GCD;int MIN;int NUM;
        node(int l,int r,int GCD,int MIN,int NUM){
        		this.l=l;
        		this.r=r;
            this.GCD=GCD;
            this.MIN=MIN;
            this.NUM=NUM;
        }
	}

	public static int GCD(int a, int b) {
		if (b==0) 
			return a;
		return GCD(b,a%b);
	}
	
	public static void build(int cur,int l,int r){
		segTree[cur]=new node(l,r,0,0,0);
	    if(l==r){
	    		segTree[cur].GCD=ori[l];
	    		segTree[cur].MIN=ori[l];
	    		segTree[cur].NUM=1;
	        return;
	    }
	    int mid=(l+r)/2,newNodeLeft=cur*2,newNodeRight=cur*2+1;
	    build(newNodeLeft,l,mid);
	    build(newNodeRight,mid+1,r);
	    segTree[cur].MIN=Math.min(segTree[newNodeLeft].MIN, segTree[newNodeRight].MIN);
	    segTree[cur].GCD=GCD(segTree[newNodeLeft].GCD, segTree[newNodeRight].GCD);
	    if(segTree[cur].GCD==segTree[newNodeRight].GCD)
	    		segTree[cur].NUM+=segTree[newNodeRight].NUM;
	    if(segTree[cur].GCD==segTree[newNodeLeft].GCD)
    			segTree[cur].NUM+=segTree[newNodeLeft].NUM;
	}
	
	public static void update(int cur,int uid){
		int l=segTree[cur].l,r=segTree[cur].r;
		if(l==r){
			segTree[cur].GCD=ori[uid];
    			segTree[cur].MIN=ori[uid];
    			segTree[cur].NUM=1;
	        return;
	    }
	    int mid=(l+r)/2,nodeLeft=cur*2,nodeRight=cur*2+1;
	    if(uid<=mid)
	    		update(nodeLeft,uid);
	    else 
	    		update(nodeRight,uid);
	    segTree[cur].MIN=Math.min(segTree[nodeLeft].MIN, segTree[nodeRight].MIN);
	    segTree[cur].GCD=GCD(segTree[nodeLeft].GCD, segTree[nodeRight].GCD);
	    segTree[cur].NUM=0;
	    if(segTree[cur].GCD==segTree[nodeRight].GCD)
    			segTree[cur].NUM+=segTree[nodeRight].NUM;
	    if(segTree[cur].GCD==segTree[nodeLeft].GCD)
			segTree[cur].NUM+=segTree[nodeLeft].NUM;
	}
	
	public static int querySmallest(int cur,int queryLeft, int queryRight){
		int l=segTree[cur].l,r=segTree[cur].r;
	    if(r==queryRight&&l==queryLeft)
	    		return segTree[cur].MIN;
	    int mid=(l+r)/2,nextLeft=cur*2,nextRight=cur*2+1;
	    if(queryRight<=mid)
    			return querySmallest(nextLeft,queryLeft,queryRight);
	    else if(queryLeft>mid)
    			return querySmallest(nextRight,queryLeft,queryRight);
	    else
	    		return Math.min(querySmallest(nextLeft,queryLeft,mid),querySmallest(nextRight,mid+1,queryRight));
	}
	
	public static int queryGCD(int cur,int queryLeft, int queryRight){
		int l=segTree[cur].l,r=segTree[cur].r;
	    if(r==queryRight&&l==queryLeft)
	    		return segTree[cur].GCD;
	    int mid=(l+r)/2,nextLeft=cur*2,nextRight=cur*2+1;
	    if(queryRight<=mid)
	    		return queryGCD(nextLeft,queryLeft,queryRight);
	    else if(queryLeft>mid)
	    		return queryGCD(nextRight,queryLeft,queryRight);
	    else
	    		return GCD(queryGCD(nextLeft,queryLeft,mid),queryGCD(nextRight,mid+1,queryRight));
	}
	
	public static int queryNum(int cur,int queryLeft, int queryRight, int val) {
		int l=segTree[cur].l,r=segTree[cur].r;
		if(l==queryLeft&&r==queryRight) {
			if(segTree[cur].GCD==val)
				return segTree[cur].NUM;
			else
				return 0;
		}
		int mid=(l+r)/2,nextLeft=cur*2,nextRight=cur*2+1;
		if(queryRight<=mid)
			return queryNum(nextLeft,queryLeft,queryRight,val);
		else if(queryLeft>mid)
			return queryNum(nextRight,queryLeft,queryRight,val);
		else
			return queryNum(nextLeft,queryLeft,mid,val)+queryNum(nextRight,mid+1,queryRight,val);
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		int b=readInt();
		ori=new int[a];
		for(int i=0;i<a;i++) 
			ori[i]=readInt();
		build(1,0,a-1);
		for(int i=0;i<b;i++) {
			String x=next();
			int m=readInt();
			int n=readInt();
			m--;
			if(x.equals("C")) {
				ori[m]=n;
				update(1,m);
			}else if(x.equals("M")) {
				n--;
				bw.write(Integer.toString(querySmallest(1,m,n)));
				bw.newLine();
			}else if(x.equals("G")) {
				n--;
				bw.write(Integer.toString(queryGCD(1,m,n)));
				bw.newLine();
			}else if(x.equals("Q")) {
				n--;
				int num=queryGCD(1,m,n);
				bw.write(Integer.toString(queryNum(1,m,n,num)));
				bw.newLine();
			}
		}
		bw.flush();

	}

}
