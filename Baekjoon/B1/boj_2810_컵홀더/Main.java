package boj_2810_컵홀더;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String string = bf.readLine();
		
		// 맨 왼쪽 컵홀더 1, 각 자리 기준 오른쪽으로 판단
		int cup = 1;
		for (int i=0; i<N; i++) {
			if (string.charAt(i) == 'L') {
				cup++;
				i++;
			} else {
				cup++;
			}
		}
		
		System.out.println(cup < N ? cup : N);
	}
}
