package platinum.boj_9376_탈옥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	final static char WALL = '*';
	final static char PATH = '.';
	final static char DOOR = '#';
	final static char PRISONER = '$';
	final static char PADDING = 0;
	static class Pos {
		int r, c, level;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Pos(int r, int c, int level) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
		}
	}
	
	static char[][] arr;
	static int R, C;
	
	// up-right-down-left
	static int[] dr = new int[] {-1,0,1,0};
	static int[] dc = new int[] {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		StringBuilder ans = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			R = Integer.parseInt(st.nextToken()) + 2;
			C = Integer.parseInt(st.nextToken()) + 2;
			
			arr = new char[R][C];
			
			
			Pos p1 = null;
			Pos p2 = null;
			
			for (int r=1; r<=R-2; r++) {
				String line = bf.readLine();
				for (int c=1; c<=C-2; c++) {
					
					char cell = line.charAt(c-1);
					//기본 정보 저장
					arr[r][c] = cell;
					
					//죄수 좌표 저장
					if (cell == PRISONER) {
						if (p1 == null) {
							p1 = new Pos(r, c, 0);
						} else {
							p2 = new Pos(r, c, 0);
						}
					}
					
				}
			}
			//인풋 끝
			
			int[][] map1 = bfs(new Pos(0, 0, 0));
			int[][] map2 = bfs(p1);
			int[][] map3 = bfs(p2);
			
//			for (int r=0; r<R; r++) {
//				for (int c=0; c<C; c++) {
//					System.out.print(map1[r][c]+map2[r][c]+map3[r][c]+" ");
//				}
//				System.out.println();
//			}
			
			int min = Integer.MAX_VALUE;
			for (int r=0; r<R; r++) {
				for (int c=0; c<C; c++) {
					char cell = arr[r][c];
					
					//아래와 같이 일반 길이나 문인데 도달할 수 없는 경우 최솟값 계산에서 제외해야함.
					//패딩의 경우도 따질 필요 없을 것 같은데?
					/*
					 * ***
					 * *.*
					 * ***
					 */
					if (cell==WALL || map1[r][c]*map2[r][c]*map3[r][c]<0) continue;
					
					int temp = map1[r][c] + map2[r][c] + map3[r][c];
					//문인 경우 1명만 열면 되므로 -2
					if (cell==DOOR) temp -= 2;
					
					if (temp<min) min = temp;
				}
			}
			
			ans.append(min+"\n");
		} //tc ends
		
		System.out.println(ans);
	}

	private static int[][] bfs(Pos pos) {
		Deque<Pos> deque = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		
		int[][] map = new int[R][C];
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				map[r][c] = -1;
			}
		}
		
		deque.add(pos);
		while (!deque.isEmpty()) {
			Pos p = deque.poll();
			int r, c, level;
			r = p.r;
			c = p.c;
			level = p.level;
			
			if (visited[r][c]) continue;
			visited[r][c] = true;
			
			map[r][c] = level;
			
			for (int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if (arr[nr][nc]==WALL) continue;
				
				if (arr[nr][nc]==PATH || arr[nr][nc]==PADDING || arr[nr][nc]==PRISONER) {
					deque.offerFirst(new Pos(nr, nc, level));
				}
				if (arr[nr][nc]==DOOR) {
					deque.offerLast(new Pos(nr, nc, level+1));
				}
			}
		}
		
		return map;
	}
}