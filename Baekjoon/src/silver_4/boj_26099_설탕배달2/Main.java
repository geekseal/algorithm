package silver_4.boj_26099_설탕배달2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(bf.readLine());
		
		if (N==3 || N==5) {
			System.out.println(1);
			return;
		} else if (N==4 || N==7) {
			System.out.println(-1);
			return;
		} else if (N==6) {
			System.out.println(2);
			return;
		}

		N = N-8;
		if (N%5==0 || N%5==2) {
			System.out.println(N/5+2);
			return;
		} else if (N%5==1 || N%5==3) {
			System.out.println(N/5+3);
			return;
		} else if (N%5==4) {
			System.out.println(N/5+4);
			return;
		}
	}
}
