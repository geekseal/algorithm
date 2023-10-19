package gold.boj_1753_최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//visited를 int배열로 만드는 것도 고려해보기
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//visited를 int배열로 만드는 것도 고려해보기
public class Main {
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		int K = sc.nextInt();
		/*
		 * V: 정점 개수
		 * E: 간선 개수
		 * K: 시작 정점의 번호
		 */
		
		adjList = new ArrayList[V+1];
		for (int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i=0; i<E; i++) {
			int u, v, w;
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();
			//directed graph
			adjList[u].add(new Node(v, w));
		}
		
		dijkstra(K);
		
		sc.close();
	}

	private static void dijkstra(int start) {
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		visited = new boolean[V+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start ,0));
		
		while (!pq.isEmpty()) {
			Node curr = pq.remove();
			if (visited[curr.v]) continue;
			
			//방문쳌, 다음 노드에 대한 거리 갱신
			visited[curr.v] = true;
			for (Node next : adjList[curr.v]) {
				if (visited[next.v]) continue;
				if (dist[curr.v]+next.w < dist[next.v]) {
					dist[next.v] = dist[curr.v]+next.w;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		
		//각 정점으로의 거리 출력
		for (int i=1; i<=V; i++) {
			System.out.println(dist[i]==Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
}