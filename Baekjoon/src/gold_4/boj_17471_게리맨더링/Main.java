package gold_4.boj_17471_게리맨더링;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] p;
	static int[][] adj;
	
	private static List<Integer>[] getPowerset() {
		int[] nums = new int[N];
		List<Integer>[] powerset = new ArrayList[1<<N];
		
		for (int i=0; i<N; i++) {
			nums[i] = i+1;
		}
		
		for (int i=0; i<(1<<N); i++) {
			List<Integer> list = new ArrayList<>();
			for (int j=0; j<N; j++) {
				if ((i & (1<<j)) > 0) {
					list.add(nums[j]);
				}
			}
			powerset[i] = list;
		}
		return powerset;
	}
	
	private static boolean isConnected(List<Integer> list) {
		if (list.size()==1) return true;
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(list.get(0));
		
		while (!q.isEmpty()) {
			int i = q.poll();
			if (visited[i]) continue;
			visited[i] = true;
			for (int j:list) {
				if (adj[i][j]==1) {
					q.offer(j);
				}
			}
		}
		
		for (int i:list) {
			if (!visited[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		p = new int[N+1];
		for (int i=1; i<=N; i++) {
			p[i] = sc.nextInt();
		}
		
		adj = new int[N+1][N+1];
		for (int a=1; a<=N; a++) {
			int E = sc.nextInt();
			for (int i=0; i<E; i++) {
				int b = sc.nextInt();
				adj[a][b] = 1;
			}
		}
		
		List<Integer>[] powerset = getPowerset();
		int[] sum = new int[1<<N];
		for (int i=1; i<(1<<N)-1; i++) {
			for (int num : powerset[i]) {
				sum[i] += p[num];
			}
		}
		
		int min = 987654321;
		for (int i=1; i<powerset.length/2; i++) {
			if (isConnected(powerset[i]) && isConnected(powerset[powerset.length-1-i])) {
				int gap = Math.abs(sum[i]-sum[sum.length-1-i]);
				if (gap < min) min = gap;
			}
		}
		
		System.out.println(min==987654321 ? -1 : min);
		
		sc.close();
	}
}
