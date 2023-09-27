package kruskal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 크루스칼
 */
public class Kruskal {
	
	static int V, E;
	static int[] parents, rank;
	
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/kruskal/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		 
		PriorityQueue<Edge> pq = new PriorityQueue<>();
				 
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(from, to, weight));
		}
		 
		make();
		
		pq.offer(new Edge(0, 0, 0));
		int count = 0;
		int result = 0;
		while(!pq.isEmpty()) {
			Edge ed = pq.poll();
			
			if(union(ed.from, ed.to)) {
				result += ed.weight;
				if(++count == V - 1) {
					break;
				}
			}
		}
		System.out.println(result);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		
		if(rank[a] > rank[b]) {
			rank[a] += rank[b];
			parents[b] = a;
		} else {
			rank[b] += rank[a];
			parents[a] = b;
		}
		return true;
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	static void make() {
		parents = new int[V + 1];
		rank = new int[V + 1];
		
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}
	}
}