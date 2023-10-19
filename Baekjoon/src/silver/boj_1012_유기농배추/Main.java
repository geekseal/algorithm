package silver.boj_1012_유기농배추;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
	static void dfs(int r, int c, int[][] arr, boolean[][] visited) {
		// should check all ways, not just right&down
		int[][] adjacents = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		
		for (int[] adjacent: adjacents) {
			int dr = adjacent[0];
			int dc = adjacent[1];
			if (r+dr>=0 && r+dr<visited.length && c+dc>=0 && c+dc<visited[0].length) {
				if (arr[r+dr][c+dc] == 1 && !visited[r+dr][c+dc]) {
					visited[r+dr][c+dc] = true;
					dfs(r+dr, c+dc, arr, visited);
				}
			}
		}
	}
	
	static int getWorm(int[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		
		int answer = 0;
		for (int r=0; r<arr.length; r++) {
			for (int c=0; c<arr[0].length; c++) {
				if (arr[r][c] == 1 && !visited[r][c]) {
					visited[r][c] = true;
					dfs(r, c, arr, visited);
					answer += 1;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("silver_2/boj_1012_유기농배추/input.txt"));
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()); 
		
		for (int test_case=0; test_case<T; test_case++) {
			String[] CRK = bf.readLine().split(" ");
			int C = Integer.parseInt(CRK[0]);
			int R = Integer.parseInt(CRK[1]);
			int K = Integer.parseInt(CRK[2]);
			int[][] arr = new int[R][C];
			
			for (int k=0; k<K; k++) {
				int[] xy = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				arr[xy[1]][xy[0]] = 1;
			}
			System.out.println(getWorm(arr));
		}
	}
}
