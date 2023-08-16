package boj_2851_슈퍼마리오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int score = 0;
		int last = 0;
		
		for (int i=0; i<10; i++) {
			if (score>=100) break;
			int num = Integer.parseInt(bf.readLine());
			score += num;
			last = num;
		}
		
		System.out.println(score-100 <= 100-(score-last) ? score : score-last);
	}
}
