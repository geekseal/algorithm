package silver_3.boj_1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[] d = new int[N+1];

		for (int i=2; i<=N; i++) {
			int d1, d2, d3;
			d1 = d2 = d3 = 987654321;
			if (i%3==0) d1 = d[i/3]+1;
			if (i%2==0) d2 = d[i/2]+1;
			d3 = d[i-1]+1;
			d[i] = Math.min(d1, Math.min(d2, d3));
		}

		System.out.println(d[N]);
	}
}
