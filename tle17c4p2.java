import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class tle17c4p2 {
	private static class pair{
        int a,b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]in;
		ArrayList<Integer>tim1=new ArrayList<Integer>();
		ArrayList<Integer>nums=new ArrayList<Integer>();
		HashMap<Integer,pair>final1=new HashMap<Integer,pair>();
		char[]use=new char[11];
		in=br.readLine().split(":");
		int a=Integer.parseInt(in[0]);
		int b=Integer.parseInt(in[1]);
		int c=Integer.parseInt(in[2]);
		use=br.readLine().toCharArray();
		for(int i=0;i<use.length;i++){
		    nums.add(use[i]-'0');
		}
		for(int i:nums) {
			for (int j:nums) {
				final1.put(i*10+j, new pair(i,j));
				tim1.add(i*10+j);
			}
		}
		int tot=a*3600+b*60+c;
		int a1=0,a2=0,a3=0;
		int diff=Integer.MAX_VALUE;
		for(int i:tim1){
			for(int j:tim1){
				for(int k:tim1){
					int summ=i*3600+j*60+k;
					if(Math.abs(tot-summ)<diff){
						diff=Math.abs(tot-summ);
						a1=i;
						a2=j;
						a3=k;
					}
				}
			}
		}
		System.out.println(final1.get(a1).a+""+final1.get(a1).b+":"+final1.get(a2).a+""+final1.get(a2).b+":"+final1.get(a3).a+""+final1.get(a3).b);

	}

}
