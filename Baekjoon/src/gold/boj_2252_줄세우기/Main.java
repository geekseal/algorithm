package gold.boj_2252_줄세우기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[] deg = new int[N+1];
		List<Integer>[] adjList = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			
			adjList[a].add(b);
			deg[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			if (deg[i]==0) {
				q.add(i);
			}
		}
		
		StringJoiner sj = new StringJoiner(" ");
		while (!q.isEmpty()) {
			int curr = q.poll();
			sj.add(String.valueOf(curr));
			
			for (int next : adjList[curr]) {
				deg[next]--;
				if (deg[next]==0) {
					q.offer(next);
				}
			}
		}
		
		System.out.println(sj);
		sc.close();
	}

}
