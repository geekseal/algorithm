package gold.boj_4811_알약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Pos {
		int i, j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(bf.readLine());
			if (N==0) break;
			
			long[][] arr = new long[N+1][N+1];
			boolean[][] visited = new boolean[N+1][N+1];
			Queue<Pos> q = new LinkedList<>();
			
			// init
			q.offer(new Pos(0, N));
			arr[0][N] = 1;
			// init end
			
			while (!q.isEmpty()) {
				Pos pos = q.poll();
				int i, j;
				i = pos.i;
				j = pos.j;
				if (visited[i][j]) continue;
				
				// upper
				if (i-1 >= 0) {
					arr[i-1][j] += arr[i][j];
					q.offer(new Pos(i-1, j));
				}
					
				// down-left
				if ((i+1 <= N) && (j-1 >= 0)) {
					arr[i+1][j-1] += arr[i][j];
					q.offer(new Pos(i+1, j-1));
				}
				
				// visit check
				visited[i][j] = true;
			}
			sb.append(arr[0][0]).append(System.lineSeparator());
		}
		System.out.print(sb);
	}
}
