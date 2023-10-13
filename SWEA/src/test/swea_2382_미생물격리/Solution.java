package test.swea_2382_미생물격리;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class Group {
		int r, c, num, d;

		public Group(int r, int c, int num, int d) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.d = d;
		}
	}
	
	static int[] dr = new int[] {0, -1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, 0, -1, 1};
	static int N, M, K;
	static List<Group>[][] arr;
	
	static int changeDir(int d) {
		if (d==1) return 2;
		if (d==2) return 1;
		if (d==3) return 4;
		return 3;
	}
	
	static void hour() {
		//1.move
		//일단 맵에 있는 미생물 집단을 다 찾아.
		List<Group> groupList = new ArrayList<>();
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				for (Group g : arr[r][c]) {
					groupList.add(g);
				}
			}
		}
		
		//찾은 집단을 가지고 순회하면서, 새로운 위치에 새로운 집단을 배치해.
		for (Group g : groupList) {
			int nr = g.r + dr[g.d];
			int nc = g.c + dc[g.d];
			int nd = g.d;
			int nnum = g.num;
			if (nr==0 || nr==N-1 || nc==0 || nc==N-1) {
				nd = changeDir(g.d);
				nnum /= 2;
			}
			
			arr[nr][nc].add(new Group(nr, nc, nnum, nd));
		}
		
		//이동시켰으니, 원래 위치에 있던 애들은 삭제해.
		for (Group g : groupList) {
			arr[g.r][g.c].remove(g);
		}
		
		//2.join
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (arr[r][c].size() >= 2) {
					int sum = 0;
					int max = 0;
					int nd = -1;
					for (Group g : arr[r][c]) {
						sum += g.num;
						if (g.num > max) {
							nd = g.d;
							max = g.num;
						}
					}
					
					arr[r][c].clear();
					arr[r][c].add(new Group(r, c, sum, nd));
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/test/swea_2382_미생물격리/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
					
			arr = new ArrayList[N][N];
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					arr[r][c] = new ArrayList<Group>();
				}
			}
			
			for (int i=0; i<K; i++) {
				int r, c, num, d;
				r = sc.nextInt();
				c = sc.nextInt();
				num = sc.nextInt();
				d = sc.nextInt();
				
				Group g = new Group(r, c, num, d);
				arr[r][c].add(g);
			}
			
			// M시간동안 반복해.
			for (int i=0; i<M; i++) {
				hour();
			}
			
			// 끝나고 난 후 arr을 순회하면서 미생물의 수를 더해.
			int ans = 0;
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					for (Group g : arr[r][c]) {
						ans += g.num;
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}

}
