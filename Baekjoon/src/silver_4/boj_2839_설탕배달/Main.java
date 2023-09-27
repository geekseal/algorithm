package silver_4.boj_2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		if (N==3 || N==5) {
			System.out.println(1);
			return;
		} else if (N==4) {
			System.out.println(-1);
			return;
		}
		
		int[][] dp = new int[N+1][2];
		dp[3][1] = 1;
		dp[5][0] = 1;
		
		for (int i=6; i<=N; i++) {
			if (dp[i-5][0]==0 && dp[i-5][1]==0) {
				if (dp[i-3][0]==0 && dp[i-3][1]==0) continue;
				dp[i][0] = dp[i-3][0];
				dp[i][1] = dp[i-3][1]+1;
			} else {
				dp[i][0] = dp[i-5][0]+1;
				dp[i][1] = dp[i-5][1];
			}
		}
		
		System.out.println(dp[N][0]+dp[N][1]==0 ? -1 : dp[N][0]+dp[N][1]);
	}
}
