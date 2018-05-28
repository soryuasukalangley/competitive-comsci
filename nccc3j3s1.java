import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class nccc3j3s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int[]arr=new int[26];
		for(int i=0;i<s.length();i++) 
			arr[s.charAt(i)-'a']++;
		Arrays.sort(arr);
		System.out.println(s.length()-arr[25]-arr[24]);

	}

}
