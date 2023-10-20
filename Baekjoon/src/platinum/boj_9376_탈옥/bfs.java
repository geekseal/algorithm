package platinum.boj_9376_탈옥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs {
	final static char WALL = '*';
	final static char PATH = '.';
	final static char DOOR = '#';
	final static char PRISONER = '$';
	static class Pos {
		int r, c, prisonerNumber;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		public Pos(int r, int c, int prisonerNumber) {
			super();
			this.r = r;
			this.c = c;
			this.prisonerNumber = prisonerNumber;
		}
	}
	
	static char[][] arr;
	static int[][][] dp;
	static boolean[][][] visited;
	static int[] dr = new int[] {0,-1,0,1};
	static int[] dc = new int[] {-1,0,1,0};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		StringBuilder ans = new StringBuilder();
		
		
		for (int tc=1; tc<=T; tc++) {
			int R, C;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			arr = new char[R][C];
			dp = new int[R][C][2];
			visited = new boolean[R][C][2];
			
			List<Pos> exits = new ArrayList<>();
			Queue<Pos> q = new LinkedList<>();
			
			//prisonerNumber: 0~1
			int prisonerNumber = 0;
			for (int r=0; r<R; r++) {
				String line = bf.readLine();
				for (int c=0; c<C; c++) {
					
					char cell = line.charAt(c);
					//기본 정보 저장
					arr[r][c] = cell;
					//출구 정보 저장
					if (cell==DOOR || cell==PATH) {
						if (r==0 || r==R-1 || c==0 || c==C-1) {
							exits.add(new Pos(r, c));
						}
					}
					//dp배열 초기화
					dp[r][c][0] = Integer.MAX_VALUE;
					dp[r][c][1] = Integer.MAX_VALUE;
					//큐에 넣기
					if (cell==PRISONER) {
						dp[r][c][prisonerNumber] = 0;
						q.offer(new Pos(r, c, prisonerNumber));
						prisonerNumber++;
					}
				}
			}
			//인풋 끝
			
			//bfs로 시도해봤는데 안 될듯
			//dfs로 해야 죄수 두명에 대해 같은 상황이 연출될듯
			
			
			
			//bfs+dp
			while (!q.isEmpty()) {
				//하나만 꺼내면 죄수 두명 반영이 안될 것 같은데
				Pos p = q.poll();
				int r, c, pn;
				r = p.r;
				c = p.c;
				pn = p.prisonerNumber;
				
				if (visited[r][c][pn]) continue;
				visited[r][c][pn] = true;
				
				for (int i=0; i<4; i++) {
					int nr = r+dr[i];
					int nc = c+dc[i];
					if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if (arr[nr][nc]==WALL) continue;
					
					//main logic
					if (arr[nr][nc]==DOOR) {
						int nw = dp[r][c][pn]+1;
						if (nw<dp[nr][nc][pn]) {
							dp[nr][nc][pn] = nw;
							q.offer(new Pos(nr, nc, pn));
						}
					} else if (arr[nr][nc]==PATH) {
						int nw = dp[r][c][pn];
						if (nw<dp[nr][nc][pn]) {
							dp[nr][nc][pn] = nw;
							q.offer(new Pos(nr, nc, pn));
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			
		}
		
		System.out.println(ans);
	}

}
