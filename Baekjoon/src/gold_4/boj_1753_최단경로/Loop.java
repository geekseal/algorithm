package gold_4.boj_1753_최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Loop: 시간초과
public class Loop {
	static class Node {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
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
		
		//정점 개수-1만큼 반복, 남은 노드의 거리도 최소로 갱신되어있을 것이기 때문
		for (int i=0; i<V-1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			
			//일단 min을 구해
			for (int j=1; j<=V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			if (idx==-1) break;
			
			//방문쳌, 다음 노드에 대한 거리 갱신
			visited[idx] = true;
			for (Node next : adjList[idx]) {
				if (visited[next.v]) continue;
				if (dist[idx]+next.w < dist[next.v]) {
					dist[next.v] = dist[idx]+next.w;
				}
			}
		}
		
		//각 정점으로의 거리 출력
		for (int i=1; i<=V; i++) {
			System.out.println(dist[i]==Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
}
