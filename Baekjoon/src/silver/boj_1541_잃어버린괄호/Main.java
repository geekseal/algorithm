package silver.boj_1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int plus(String v) {
		return Arrays.stream(v.split("\\+")).mapToInt(num -> Integer.parseInt(num)).sum();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = bf.readLine().trim().split("-");
		
		int[] parenthesized = Arrays.stream(arr).mapToInt(v -> plus(v)).toArray();
		
		int answer = 0;
		for (int i=0; i<parenthesized.length; i++) {
			if (i==0) {
				answer += parenthesized[i];
				continue;
			}
			answer -= parenthesized[i];
		}
		System.out.println(answer);
	}
}
