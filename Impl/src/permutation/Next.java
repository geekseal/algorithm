package permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Next {
	static int N;
	static int[] next(int[] arr) {
		boolean isLast = true;
		
		for (int i=N-1; i>=1; i--) {
			if (arr[i-1] < arr[i]) {
				for (int j=N-1; j>=0; j--) {
					if (arr[j] > arr[i-1]) {
						// swap
						int temp = arr[i-1];
						arr[i-1] = arr[j];
						arr[j] = temp;
						
						// ascending order
						for (int k=0; k<(N-i)/2; k++) {
							temp = arr[i+k];
							arr[i+k] = arr[N-1-k];
							arr[N-1-k] = temp;
						}
						
						break;
					}
				}
				isLast = false;
				break;
			}
		}
		
		return isLast ? null : arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] permu = new int[N];
		for (int i=0; i<N; i++) {
			permu[i] = i;
		}
		
		System.out.println(Arrays.toString(permu));
		int[] next = next(permu);
		int cnt = 1;
		while (next != null) {
			System.out.println(Arrays.toString(next));
			next = next(next);
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
