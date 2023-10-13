package D4.swea_1210_ladder1;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
	static int search(int sy, int sx, String[][] arr) {
		// order matters, because search of left or right should be prior to up.
		int[][] adj = {{0, -1}, {0, 1}, {-1, 0}};
		boolean[][] visited = new boolean[100][100];
		
		// current x and y, to trace current position.
		int cx = sx;
		int cy = sy;
		
		int R = arr.length;
		int C = arr[0].length;
		
		while (cy != 0) {
			for (int[] coordinate: adj) {
				visited[cy][cx] = true;
				int dy = coordinate[0];
				int dx = coordinate[1];
				
				if (cy+dy>=0 && cy+dy<R && cx+dx>=0 && cx+dx<C) {
					if (arr[cy+dy][cx+dx].equals("1") && !visited[cy+dy][cx+dx]) {
						// update newly visited
						visited[cy+dy][cx+dx] = true;
						
						// set to current position
						cy = cy+dy;
						cx = cx+dx;
						break;
					}
				}
			}
		}
		return cx;
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("D4/swea_1210_ladder1/input.txt"));
		Scanner sc = new Scanner(System.in);
	
		for(int t = 0; t < 10; t++)
		{
			int test_case = Integer.parseInt(sc.nextLine());
			
			String[][] arr = new String[100][100];
			int sx = 0, sy = 99;
			
			// get input array
			for (int row=0; row<100; row++) {				
				arr[row] = sc.nextLine().split(" ");
			}
			// find starting x
			for (int x=0; x<100; x++) {
				if (arr[sy][x].equals("2")) {
					sx = x;
					break;
				}
			}
			
			// search
			System.out.printf("#%d %d\n", test_case, search(sy, sx, arr));
		}
		sc.close();
	}
}
