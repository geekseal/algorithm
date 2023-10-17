package permutation;

import java.util.Arrays;

public class NextPermutation {
	static int N = 4;
	static boolean np(int[] p) {
		//1. 뒤에서부터 증가하는 구간 찾기
		int N = p.length;
		int i = N-1;
		while (i>0 && p[i-1] >= p[i]) i--;
		if (i==0) return false;
		
		//2. 증가하는 구간의 앞 요소와 스왑할 요소 찾기
		int j = N-1;
		while (p[i-1] >= p[j]) j--;
		
		//3. 스왑
		swap(p, i-1, j);
		
		//4. 스왑한 뒷 부분을 오름차순 정렬
		int k = N-1;
		while (i<k) swap(p, i++, k--);
		
		return true;
	}

	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = i;
		}
		
		do {
			System.out.println(Arrays.toString(arr));
		} while (np(arr));
	}

}