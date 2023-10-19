package silver.boj_1389_케빈베이컨의6단계법칙;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> adjacent;
	static int N, M;
	static int[] baconNumbers;
	
	static void bfs(int v) {
		boolean[] visited = new boolean[N+1];
		int[] cnt = new int[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			if (!visited[curr]) {
				visited[curr] = true;
				baconNumbers[v] += cnt[curr];
			}
			
			for (int child : adjacent.get(curr)) {
				if (!q.contains(child) && !visited[child]) {
					q.offer(child);
					cnt[child] += cnt[curr]+1; //부모의 카운트(즉 부모가 언제 방문됐는지) + 자식이 방문될 때 고려
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		adjacent = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<=N; i++) {
			adjacent.add(new ArrayList<>());
		}
		
		//bfs gives you the shortest path to any other vertex.
		for (int i=0; i<M; i++) {
			int A, B;
			A = sc.nextInt();
			B = sc.nextInt();
			
			adjacent.get(A).add(B);
			adjacent.get(B).add(A);
		}
		
		// get bacon numbers for each vertex i
		baconNumbers = new int[N+1];
		for (int i=1; i<=N; i++) {
			bfs(i);
		}
		
		// get min
		double minBaconNumber = Double.POSITIVE_INFINITY;
		int answer = 0;
		for (int i=N; i>=1; i--) { // 겹칠 경우 작은 수를 출력하기 위해 뒤에서부터 순회
			if (baconNumbers[i] <= minBaconNumber) {
				minBaconNumber = baconNumbers[i];
				answer = i;
			}
		}
		System.out.println(answer);
		sc.close();
	}

}
