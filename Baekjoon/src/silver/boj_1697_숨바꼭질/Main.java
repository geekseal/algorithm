package silver.boj_1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int start, end; //0 <= N,K <= 100,000
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		if (start >= end) {
			System.out.println(start-end);
			return;
		}
		
		// start < end
		d = new int[end*2];
		visited = new boolean[end*2];
		System.out.println(search(start, end));
		
	}
	
	static int[] d;
	static boolean[] visited;
	
	static int search(int start, int end) {
		// start < end is guaranteed
		Queue<Integer> q = new LinkedList<>();
		q.offer(end);
		
		while (true) {
			int curr = q.poll();
			if (curr==start) break;
			
			// add adjacent
			if (curr-1 >= 0 && !visited[curr-1]) {
				d[curr-1] = d[curr]+1;
				q.offer(curr-1);
				visited[curr-1] = true;
				if (curr-1 == start) break;
			}
			if (!visited[curr+1]) {
				d[curr+1] = d[curr]+1;
				q.offer(curr+1);
				visited[curr+1] = true;
				if (curr+1 == start) {
					break;
				}
			}
			
			// divide by 2
			if (curr%2!=0) continue;
			if (!visited[curr/2]) {
				d[curr/2] = d[curr]+1;
				q.offer(curr/2);
				visited[curr/2] = true;
				if (curr/2 == start) break;
			}
			
		}
		
		return d[start];
	}
}
