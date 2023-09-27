package silver_1.boj_5014_스타트링크;

import java.util.Arrays;
import java.util.Scanner;

public class Dfs {
	static int F, S, G, U, D;
	static int[] d;
	static boolean[] visited;
	
	private static void dfs() {
		if (G>S) {
			up(S+U);
		} else {
			down(S-D);
		}
	}
	
	private static void up(int idx) {
		if (idx > F || visited[idx]) return;
		
		if (idx-U >= 1) {
			int nd = d[idx-U]+1;
			if (nd < d[idx]) {
				d[idx] = nd;
			}
			visited[idx] = true;
		}
		
		if (idx == G) return;
		
		up(idx+U);
		down(idx-D);
	}
	
	private static void down(int idx) {
		if (idx < 1 || visited[idx]) return;
		
		if (idx+D <= F) {
			int nd = d[idx+D]+1;
			if (nd < d[idx]) {
				d[idx] = nd;
			}
			visited[idx] = true;
		}
		
		if (idx == G) return;
		
		down(idx-D);
		up(idx+U);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		// G==S
		if (G==S) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		d = new int[F+1];
		Arrays.fill(d, 987654321);
		d[S] = 0;
		visited = new boolean[F+1];
		dfs();
		
		System.out.println(d[G] != 987654321 ? d[G] : "use the stairs");
		
		sc.close();
	}


	

}
