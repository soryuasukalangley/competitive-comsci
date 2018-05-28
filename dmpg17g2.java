import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class dmpg17g2 {
	static BufferedReader br; 
	static StringTokenizer st; 
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st=new StringTokenizer(br.readLine().trim());
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
	
	static node[] segTree=new node[300000];
	static int[]ori;
	
	public static class node{
		int l, r;
		long SUM,maxSUM,leftSUM,rightSUM;
        node(int l,int r,long SUM,long maxSUM,long leftSUM,long rightSUM){
        		this.l=l;
        		this.r=r;
        		this.SUM=SUM;
        		this.maxSUM=maxSUM;
        		this.leftSUM=leftSUM;
        		this.rightSUM=rightSUM;
        }
	}
	
	public static void set(int idx,int newNodeLeft,int newNodeRight) {
		segTree[idx].SUM=segTree[newNodeLeft].SUM+segTree[newNodeRight].SUM;
		segTree[idx].leftSUM=Math.max(segTree[newNodeLeft].leftSUM, segTree[newNodeLeft].SUM+segTree[newNodeRight].leftSUM);
		segTree[idx].rightSUM=Math.max(segTree[newNodeRight].rightSUM, segTree[newNodeRight].SUM+segTree[newNodeLeft].rightSUM);
		segTree[idx].maxSUM=Math.max(segTree[newNodeLeft].maxSUM, segTree[newNodeRight].maxSUM);
		segTree[idx].maxSUM=Math.max(segTree[idx].maxSUM, segTree[idx].leftSUM);
		segTree[idx].maxSUM=Math.max(segTree[idx].maxSUM, segTree[idx].rightSUM);
		segTree[idx].maxSUM=Math.max(segTree[idx].maxSUM, segTree[idx].SUM);
		segTree[idx].maxSUM=Math.max(segTree[idx].maxSUM, segTree[newNodeLeft].rightSUM+segTree[newNodeRight].leftSUM);
	}
	
	public static void build(int cur,int l,int r){
		segTree[cur]=new node(l,r,0,0,0,0);
	    if(l==r){
	    		segTree[cur].SUM=segTree[cur].maxSUM=segTree[cur].leftSUM=segTree[cur].rightSUM=ori[l];
	        return;
	    }
	    int mid=(l+r)/2,newNodeLeft=cur*2,newNodeRight=cur*2+1;
	    build(newNodeLeft,l,mid);
	    build(newNodeRight,mid+1,r);
	    set(cur,newNodeLeft,newNodeRight);
	}
	
	public static void update(int cur,int uid){
		int l=segTree[cur].l,r=segTree[cur].r;
		if(l==r){
			segTree[cur].SUM=segTree[cur].maxSUM=segTree[cur].leftSUM=segTree[cur].rightSUM=ori[uid];
	        return;
	    }
	    int mid=(l+r)/2,nodeLeft=cur*2,nodeRight=cur*2+1;
	    if(uid<=mid)
	    		update(nodeLeft,uid);
	    else 
	    		update(nodeRight,uid);
	    set(cur,nodeLeft,nodeRight);
	}
	
	public static node query(int cur,int queryLeft, int queryRight){
		int l=segTree[cur].l,r=segTree[cur].r;
		node n1=new node(l,r,0,0,0,0);
	    if(r==queryRight&&l==queryLeft) {
	    		n1.SUM=segTree[cur].SUM;
	    		n1.maxSUM=segTree[cur].maxSUM;
	    		n1.leftSUM=segTree[cur].leftSUM;
	    		n1.rightSUM=segTree[cur].rightSUM;
	    		return n1;
	    }
	    node n2,n3;
		n2=new node(l,r,0,0,0,0);
		n3=new node(l,r,0,0,0,0);
	    int mid=(l+r)/2,nextLeft=cur*2,nextRight=cur*2+1;
	    if(queryRight<=mid)
    			return n2=query(nextLeft,queryLeft,queryRight);
	    else if(queryLeft>mid)
    			return n3=query(nextRight,queryLeft,queryRight);
	    else {
	    		n2=query(nextLeft,queryLeft,mid);
	    		n3=query(nextRight,mid+1,queryRight);
	    }
	    	n1.SUM=n2.SUM+n3.SUM;
	    	n1.leftSUM=Math.max(n2.leftSUM, n2.SUM+n3.leftSUM);
	    	n1.rightSUM=Math.max(n3.rightSUM, n3.SUM+n2.rightSUM);	
	   	n1.maxSUM=Math.max(n2.maxSUM, n3.maxSUM);
	    	n1.maxSUM=Math.max(n1.maxSUM, n1.leftSUM);
	   	n1.maxSUM=Math.max(n1.maxSUM, n1.rightSUM);
	    	n1.maxSUM=Math.max(n1.maxSUM, n1.SUM);
	    	n1.maxSUM=Math.max(n1.maxSUM, n2.rightSUM+n3.leftSUM);
	    	return n1;
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=readInt();
		int b=readInt();
		ori=new int[a+1];
		for(int i=1;i<=a;i++) {
			ori[i]=readInt();
		}
		build(1,1,a);
		for(int i=0;i<b;i++) {
			String q=next();
			int l=readInt();
			int r=readInt();
			if(q.equals("S")) {
				ori[l]=r;
				update(1,l);
			}else 
				bw.write(Long.toString(query(1,l,r).maxSUM));
		}
		bw.flush();

	}

}
