package D3.swea_1206_view;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int answer = 0;
			for (int i=2; i<N-2; i++) {
				int lmax = arr[i-2] > arr[i-1] ? arr[i-2] : arr[i-1]; 
				int rmax = arr[i+2] > arr[i+1] ? arr[i+2] : arr[i+1];
				answer += arr[i] > Math.max(lmax, rmax) ? arr[i] - Math.max(lmax, rmax) : 0;
			}
			System.out.printf("#%s %s\n", test_case, answer);
			
		}
		sc.close();
	}
}