//fail, stackoverflow
package silver.boj_5014_스타트링크;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int F, S, G, U, D;
	static int[] graph;
	static boolean[] visited;
	
	private static void bfs() {
		graph[S] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		
		while (!q.isEmpty()) {
			int idx = q.poll();
			if (visited[idx]) continue;
			
			visited[idx] = true;
			
			if (idx+U <= F) {
				int nd = graph[idx]+1;
				if (nd < graph[idx+U]) {
					graph[idx+U] = nd;
					q.offer(idx+U);
				}
			}
			
			if (idx-D >= 1) {
				int nd = graph[idx]+1;
				if (nd < graph[idx-D]) {
					graph[idx-D] = nd;
					q.offer(idx-D);
				}
			}
			
			if (idx == G) break;
		}
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
		
		graph = new int[F+1];
		Arrays.fill(graph, 987654321);
		visited = new boolean[F+1];
		bfs();
		
		System.out.println(graph[G] != 987654321 ? graph[G] : "use the stairs");
		
		sc.close();
	}
}
