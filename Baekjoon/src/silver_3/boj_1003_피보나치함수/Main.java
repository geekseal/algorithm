package silver_3.boj_1003_피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// {{for zero(cur, prev)} {for one(cur, prev)}}
	private static int[][] fibo(int n) {
		if (n == 0) {
			return new int[][] {{1, 0}, {0, 0}};
		} else if (n == 1) {
			return new int[][] {{0, 1}, {1, 0}};
		}
		
		int arr[][] = new int[2][2];
		
		int idx = 0;
		for (int[] v: fibo(n-1)) {
			int curr, prev;
			curr = v[0];
			prev = v[1];
			arr[idx][0] = curr+prev;
			arr[idx][1] = curr;	
			idx++;
		}
		
		return arr;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()); 
		String answer = "";
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bf.readLine()); 
			int[][] fibo = fibo(N);
			answer += String.format("%s %s%n", fibo[0][0], fibo[1][0]);
		}
		System.out.println(answer);
	}
}