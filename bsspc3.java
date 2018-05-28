import java.io.BufferedWriter;
import java.util.Scanner;

public class bsspc3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tang=sc.nextInt();
		int woShiDanShenGouGanMaGeiWoKanZheGe=sc.nextInt();
		int wrappers=0;
		int total=0;
		do {
			total+=tang;
			wrappers+=tang;
			tang=wrappers/woShiDanShenGouGanMaGeiWoKanZheGe;
			wrappers=wrappers%woShiDanShenGouGanMaGeiWoKanZheGe;
		} while(tang>0);
		System.out.println(total);

	}

}
