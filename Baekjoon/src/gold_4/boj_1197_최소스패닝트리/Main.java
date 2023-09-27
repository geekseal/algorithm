package gold_4.boj_1197_최소스패닝트리;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int a, b, c;

	public Edge(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public int compareTo(Edge o) {
		return this.c - o.c;
	}
}

public class Main {
	static int V, E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		List<Edge>[] adjList = new ArrayList[V+1];
		
		for (int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i=0; i<E; i++) {
			int a, b, c;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			adjList[a].add(new Edge(a, b, c));
			adjList[b].add(new Edge(b, a, c));
		}
		
		//pick edges
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		//간선이 없는 정점은 없음.
		pq.addAll(adjList[1]);
		visited[1] = true;
		int ans = 0;
		int pick = 1;

		while (pick != V) {
			Edge e = pq.poll();
			if (visited[e.b]) continue;
			visited[e.b] = true;
			
			ans += e.c;
			pq.addAll(adjList[e.b]);
			pick++;
		}
		
		pq.clear();
		
		System.out.println(ans);
		
		sc.close();
	}

}
