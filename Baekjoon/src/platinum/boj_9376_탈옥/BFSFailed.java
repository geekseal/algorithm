package platinum.boj_9376_탈옥;
// https://www.acmicpc.net/board/view/105529
// https://www.acmicpc.net/board/view/89630


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSFailed {
	final static char WALL = '*';
	final static char PATH = '.';
	final static char DOOR = '#';
	final static char PRISONER = '$';
	static class Pos {
		int r, c, prisonerNumber, pr, pc, dir;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Pos(int r, int c, int prisonerNumber, int pr, int pc, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.prisonerNumber = prisonerNumber;
			this.pr = pr;
			this.pc = pc;
			this.dir = dir;
		}
	}
	
	static char[][] arr;
	static int[][][] dp;
	static List<Pos> exits;
	
	static final int VISITED = 0;
	static final int UP = 1;
	static final int RIGHT = 2;
	static final int DOWN = 3;
	static final int LEFT = 4;
	/*
	 * visited
	 * 0: unvisited
	 * 1: up
	 * 2: right
	 * 3: down
	 * 4: left
	 */
	static int[][][] directed;
	// up-right-down-left
	static int[] dr = new int[] {0,-1,0,1,0};
	static int[] dc = new int[] {0,0,1,0,-1};
	
	static int N;
	static int K = 2;
	static int[] perm = new int[K];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
//		StringBuilder ans = new StringBuilder();
		
		
		for (int tc=1; tc<=T; tc++) {
			int R, C;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			arr = new char[R][C];
			dp = new int[R][C][3];
			directed = new int[R][C][2];
			
			exits = new ArrayList<>();
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
					if (cell==DOOR || cell==PATH || cell==PRISONER) {
						if (r==0 || r==R-1 || c==0 || c==C-1) {
							exits.add(new Pos(r, c));
						}
					}
					//dp배열 초기화
					dp[r][c][0] = Integer.MAX_VALUE;
					dp[r][c][1] = Integer.MAX_VALUE;
					dp[r][c][2] = Integer.MAX_VALUE;
					//큐에 넣기
					if (cell==PRISONER) {
						dp[r][c][prisonerNumber] = 0;
						dp[r][c][2] = 0;
						for (int i=1; i<=4; i++) {
							// i means direction
							int nr = r+dr[i];
							int nc = c+dc[i];
							if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
							if (arr[nr][nc]==WALL) continue;
							
							q.offer(new Pos(nr, nc, prisonerNumber, r, c, i));
						}
						prisonerNumber++;
					}
				}
			}
			//인풋 끝
			
			//bfs+dp
			while (!q.isEmpty()) {
				Pos p = q.poll();
				int r, c, pn, pr, pc, dir;
				r = p.r;
				c = p.c;
				pn = p.prisonerNumber;
				pr = p.pr;
				pc = p.pc;
				dir = p.dir;
				
//				if (directed[r][c][pn]>0) continue;
				//4방 다 방문해야함
				directed[r][c][pn] = dir;
				
				//main logic
//				if (r == 1 && c == 4) {
//					System.out.println("pn: "+pn+" nr: "+r+" nc: "+c+" directed: "+dir);
//				}
				if (arr[r][c]==DOOR) {
					int nw = dp[pr][pc][pn] + 1;
					if (nw<dp[r][c][pn]) {
						dp[r][c][pn] = nw;
						
						for (int i=1; i<=4; i++) {
							// i means direction
							int nr = r+dr[i];
							int nc = c+dc[i];
							if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
							if (arr[nr][nc]==WALL) continue;
							
							q.offer(new Pos(nr, nc, pn, r, c, i));
						}
					}
					
					//상대방이 이미 방문했을 때 갱신
					if (directed[r][c][1-pn]>0) {
						//상대방과 나의 방향이 같으면
						if (directed[r][c][1-pn] == directed[r][c][pn]) {
							int nd = dp[pr][pc][2]+1;
							if (nd<dp[r][c][2]) {
								dp[r][c][2] = nd;
								
								for (int i=1; i<=4; i++) {
									// i means direction
									int nr = r+dr[i];
									int nc = c+dc[i];
									if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
									if (arr[nr][nc]==WALL) continue;
									
									q.offer(new Pos(nr, nc, pn, r, c, i));
								}
							}
						} else {
							//다르면
							int nd = dp[r][c][0]+dp[r][c][1]-1;
							if (nd<dp[r][c][2]) {
								dp[r][c][2] = nd;
								
								for (int i=1; i<=4; i++) {
									// i means direction
									int nr = r+dr[i];
									int nc = c+dc[i];
									if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
									if (arr[nr][nc]==WALL) continue;
									
									q.offer(new Pos(nr, nc, pn, r, c, i));
								}
							}
						}
					}
					
					
				} else if (arr[r][c]==PATH || arr[r][c]==PRISONER) {
					int nw = dp[pr][pc][pn];
					if (nw<dp[r][c][pn]) {
						dp[r][c][pn] = nw;
						
						for (int i=1; i<=4; i++) {
							// i means direction
							int nr = r+dr[i];
							int nc = c+dc[i];
							if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
							if (arr[nr][nc]==WALL) continue;
							
							q.offer(new Pos(nr, nc, pn, r, c, i));
						}
					}
					
					//상대방이 이미 방문했을 때 갱신
					if (directed[r][c][1-pn]>0) {
						//상대방과 나의 방향이 같으면
						if (directed[r][c][1-pn] == directed[r][c][pn]) {
							int nd = dp[pr][pc][2];
							if (nd<dp[r][c][2]) {
								dp[r][c][2] = nd;
								
								for (int i=1; i<=4; i++) {
									// i means direction
									int nr = r+dr[i];
									int nc = c+dc[i];
									if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
									if (arr[nr][nc]==WALL) continue;
									
									q.offer(new Pos(nr, nc, pn, r, c, i));
								}
							}
						} else {
							//다르면
							int nd = dp[r][c][0]+dp[r][c][1];
							if (nd<dp[r][c][2]) {
								dp[r][c][2] = nd;
								
								for (int i=1; i<=4; i++) {
									// i means direction
									int nr = r+dr[i];
									int nc = c+dc[i];
									if (nr<0 || nr>=R || nc<0 || nc>=C) continue;
									if (arr[nr][nc]==WALL) continue;
									
									q.offer(new Pos(nr, nc, pn, r, c, i));
								}
							}
						}
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			for (Pos p : exits) {
				int temp = dp[p.r][p.c][2];
				if (dp[p.r][p.c][0]<Integer.MAX_VALUE && dp[p.r][p.c][1]<Integer.MAX_VALUE && temp<min) {
					//모두 방문했으면서!
					min = temp;
				}
			}
			
//			System.out.println(min);
			
			if (exits.size()>=2) {
				N = exits.size();
				perm(0, 0);
			}
			
//			ans.append(min+"\n");
			System.out.println(min);
			
//			for (int r=0; r<R; r++) {
//				for (int c=0; c<C; c++) {
//					System.out.print(dp[r][c][0]+","+dp[r][c][1]+","+dp[r][c][2] + " ");
//				}
//				System.out.println();
//			}
			
		} //tc ends
		
//		System.out.println(ans);
	}

	static int min;
	private static void perm(int idx, int visited) {
		if (idx==K) {
			//main logic
			int temp = 0;
			for (int prisonerNumber=0; prisonerNumber<2; prisonerNumber++) {
				int exitIdx = perm[prisonerNumber];
				Pos p = exits.get(exitIdx);
				int r, c;
				r = p.r;
				c = p.c;
				
				if (dp[r][c][prisonerNumber]==Integer.MAX_VALUE) return;
				temp += dp[r][c][prisonerNumber];
			}
			if (temp<min) {
				min = temp;
			}
			
			return;
		}
		
		for (int i=0; i<N; i++) {
			if ((visited & (1<<i)) > 0) continue;
			perm[idx] = i;
			perm(idx+1, visited | (1<<i));
		}
	}
}
