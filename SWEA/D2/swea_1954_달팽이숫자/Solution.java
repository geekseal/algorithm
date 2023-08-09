package swea_1954_달팽이숫자;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int data = 1;
			int layer = N/2 + 1;
			
			for (int i=0; i<layer; i++) {
				int y = i;
				int x = y;
				
				// going right-down			
				while (y < N) {
					while (x < N) {
						arr[y][x] = data;
						data++;
						x++;
					}
					x--;
					y++;
				}
				y--;
				data--;
				
				// going left-up
				while (y > i) {
					while (x >= i) {
						arr[y][x] = data;
						data++;
						x--;
					}
					x++;
					y--;
				}
				
				N--;
			}
			
			System.out.printf("#%s\n", test_case);
			for (int[] row: arr) {
				for (int col: row) {
					System.out.print(col + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
	
}
