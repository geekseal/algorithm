package gold.boj_2533_사회망서비스;

// https://velog.io/@qwerty1434/%EB%B0%B1%EC%A4%80-2533%EB%B2%88-%EC%82%AC%ED%9A%8C%EB%A7%9D-%EC%84%9C%EB%B9%84%EC%8A%A4SNS
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static ArrayList<Integer>[] edges;
	static int[][] dp;
	static boolean[] visited;

	private static void DFS(int now) {
		/*
		 * x를 선택하지 않으면 x와 연결된 모든 노드는 반드시 선택해야 합니다.
		 * x를 선택하면 x와 연결된 모든 노드는 '선택해도 되고 선택하지 않아도 됩니다'.
		 * 이를 바탕으로 dp배열에 들어가는 값을 해당 노드까지 고려했을 때 해당 노드 아래로 모두 얼리 어답터가 되기 위해 선택한 최소한의 노드 수라고 정의할 수 있습니다.
		 * 
		 * dp[0][x]: x를 선택하지 않고 x아래를 모두 얼리 어답터로 만드는 최소 경우의 수
		 * dp[1][x]: x를 선택하고 x아래를 모두 얼리 어답터로 만드는 최소 경우의 수
		 * 
		 * root로 지정한 노드가 바뀌어도 되는가? 모든 값을 root로 두고 풀어야 하는거 아닐까? -> 실제로는 depth가 아니라 연결된 형태에 영향을 받기 때문에 상관이 없습니다.
		 * BFS를 쓰면 안되는가? -> 안됩니다. BFS는 해당 노드를 탐색하는 시점에 자식들의 dp값을 알지 못합니다. 하지만 DFS는 재귀를 호출하는 부분이 끝난 뒤에는 자식들의 dp값을 알기 때문에 문제를 DFS로 풀어야 합니다.
		 */
		
		visited[now] = true;
		dp[0][now] = 0;
		dp[1][now] = 1;
		
		//먼저 방문한 정점을 부모라 상정하고 자식 순회
		for (int next : edges[now]) {
			//자식 자격 박탈
			//어떠한 자식이 이미 방문되었다는 것은 이미 다른 부모에 의해 방문되었음을 의미
			if (visited[next]) continue;
			
			//부모로서의 역할
			DFS(next);
			dp[0][now] += dp[1][next];
			dp[1][now] += Math.min(dp[0][next], dp[1][next]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		edges = new ArrayList[N+1];
		dp = new int[2][N+1];
		visited = new boolean[N+1];
		
		for (int v=1; v<=N; v++) {
			edges[v] = new ArrayList<>();
		}
		for (int e=0; e<N-1; e++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			
			edges[a].add(b);
			edges[b].add(a);
		}
		
		//시작 정점은 아무 정점이나 상관 없다.
		int root = (int) Math.random()*N + 1;
		DFS(root);
		
		System.out.println(Math.min(dp[0][root], dp[1][root]));
		
		sc.close();
	}

}
