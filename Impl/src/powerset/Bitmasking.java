package powerset;

import java.util.Arrays;

public class Bitmasking {
	static int[] arr;
	
	public static void main(String[] args) {
		arr = new int[] {1,5,1,3,1};
		powerset();
	}

	private static void powerset() {
		Arrays.sort(arr);
		int N = arr.length;
		
		//모든 부분집합의 개수만큼 반복
		for (int i=0; i<(1<<N); i++) {
			for (int j=0; j<N; j++) {
				if ((i & (1<<j)) > 0) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
	}
}
