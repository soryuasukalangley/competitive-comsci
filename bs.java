
public class bs {
	public static int bs(int[]arr,int beg,int end,int target) {
		int mid=(beg+end)/2;
		if(end<0||beg>arr.length-1)
			return -1;
		if(arr[mid]==target)
			return mid;
		else
			return (arr[mid]>target)?bs(arr,beg,mid-1,target):bs(arr,mid+1,end,target);
	}

	public static void main(String[] args) {
		int[]lol= {1,2,3,4,5};
		System.out.println(bs(lol,0,lol.length-1,5));

	}

}
