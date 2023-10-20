package gold.boj_2533_사회망서비스;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GreedyFailed {
	static class Node implements Comparable<Node> {
		int v, deg;

		public Node(int v, int deg) {
			super();
			this.v = v;
			this.deg = deg;
		}

		@Override
		public int compareTo(Node o) {
			//내림차순
			return o.deg - this.deg;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] deg = new int[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		ArrayList<Integer>[] edges = new ArrayList[N+1];
		for (int v=1; v<=N; v++) {
			edges[v] = new ArrayList<>();
		}
		
		for (int e=0; e<N-1; e++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			
			deg[a]++;
			deg[b]++;
			
			edges[a].add(b);
			edges[b].add(a);
		}
		
		for (int v=1; v<=N; v++) {
			pq.add(new Node(v, deg[v]));
		}
		
		int ans = 0;
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (deg[n.v]==0) continue;
			
			//차수가 업데이트된 경우
			if (n.deg != deg[n.v]) {
				pq.offer(new Node(n.v, deg[n.v]));
				continue;
			}
			
			//얼리어답터로 선택
			deg[n.v] = 0;
			ans++;
			
			//인접한 친구의 차수-1
			for (int adj : edges[n.v]) {
				deg[adj] -= deg[adj]==0 ? 0 : 1;
				pq.offer(new Node(adj, deg[adj]));
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}


}
