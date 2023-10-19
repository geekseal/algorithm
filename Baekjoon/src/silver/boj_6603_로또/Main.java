package silver.boj_6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N;
	static int K=6;
	static int[] sel = new int[K];
	static StringBuilder sb = new StringBuilder();
	
	private static void combination(int idx, int sidx) {
		if (sidx==K) {
			StringJoiner sj = new StringJoiner(" ");
			for (int i=0; i<K; i++) {
				sj.add(String.valueOf(sel[i]));
			}
			sb.append(sj+System.lineSeparator());
			return;
		}
		
		for (int i=idx; i<=N-K+sidx; i++) {
			sel[sidx] = arr[i];
			combination(i+1, sidx+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N==0) break;
			
			arr = new int[N];
			for (int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			sb.append(System.lineSeparator());
		}
		System.out.println(sb);
	}

	
	

}
