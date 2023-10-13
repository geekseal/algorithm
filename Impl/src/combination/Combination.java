package combination;

import java.util.Arrays;

public class Combination {
	static int[] arr;
	static int N;
	static int K;
	static int[] sel;
	
	private static void combination(int idx, int sidx) {
		if (sidx==K) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for (int i=idx; i<=N-K+sidx; i++) {
			sel[sidx] = arr[i];
			combination(i+1, sidx+1);
		}
	}
	
	public static void main(String[] args) {
		N = 7;
		K = 3;
		arr = new int[] {1,2,3,4,5,6,7};
		sel = new int[K];
		
		combination(0, 0);
	}
}
