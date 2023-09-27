package powerset;

import java.util.Arrays;

public class Recursion {
	static int[] arr;
	static boolean[] sel;
	static int N;
	
	public static void main(String[] args) {
		arr = new int[] {1,5,1,3,1};
		N = arr.length;
		sel = new boolean[N];
		
		Arrays.sort(arr);
		powerset(0);
	}

	private static void powerset(int idx) {
		//기저
		if (idx == N) {
			for (int i=0; i<N; i++) {
				if (sel[i]) System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		//재귀
		sel[idx] = false;
		powerset(idx+1);
		sel[idx] = true;
		powerset(idx+1);
	}
}
