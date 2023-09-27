package gold_4.boj_1647_도시분할계획;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	//대표를 저장할 배열
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V, E;
		V = sc.nextInt();
		E = sc.nextInt();
		
		//[0]:시작정점 [1]:끝정점 [2]:가중치
		int[][] edges = new int[E][3];
		
		for (int i=0; i<E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		//initialize end
		
		//sort edges
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		//make group
		p = new int[V+1];
		for (int i=1; i<=V; i++) {
			makeset(i);
		}
		
		//pick edges
		int ans = 0;
		int max = 0;
		int pick = 0;
		
		for (int i=0; i<E; i++) {
			int px, py;
			px = findset(edges[i][0]);
			py = findset(edges[i][1]);
			
			if (px!=py) {
				union(px, py);
				ans += edges[i][2];
				if (edges[i][2] > max) max = edges[i][2];
				pick++;
			}
			
			if (pick==V-1) break;
		}
		
		System.out.println(ans-max);
		sc.close();
	}

	private static void union(int x, int y) {
		p[y] = x;
	}

	private static int findset(int x) {
		//path compression
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}

	private static void makeset(int i) {
		p[i] = i;
	}
}
