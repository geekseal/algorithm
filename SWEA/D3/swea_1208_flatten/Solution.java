package swea_1208_flatten;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution
{
	static void mergeSort(int[] S) {
		int n = S.length;
		if (n < 2) {
			return;
		}
		
		int mid = n/2;
		int[] S1 = IntStream.range(0, mid).map(idx -> S[idx]).toArray();
		int[] S2 = IntStream.range(mid, n).map(idx -> S[idx]).toArray();
		mergeSort(S1);
		mergeSort(S2);
		
		merge(S1, S2, S);
	}
	
	static void merge(int[] S1, int[] S2, int[] S) {
		int i = 0, j = 0;
		while (i+j < S.length) {
			if (j == S2.length || (i < S1.length && S1[i] < S2[j])) {
				S[i+j] = S1[i];
				i++;
			} else {
				S[i+j] = S2[j];
				j++;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("D3/swea_1208_flatten/input.txt"));

		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int D = Integer.parseInt(sc.nextLine());
			int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			mergeSort(arr);
			
			for (int i=0; i<D; i++) {
				if (arr[99] - arr[0] <= 1) {
					break;
				}
				
				arr[0]++;
				arr[99]--;
				
				int lptr = 0;
				int rptr = 99;
				// shift arr[0] until it finds its place
				while (arr[lptr] > arr[lptr+1]) {
					int temp = arr[lptr+1];
					arr[lptr+1] = arr[lptr];
					arr[lptr] = temp;
					lptr++;
				}
				// shift arr[99] until it finds its place
				while (arr[rptr] < arr[rptr-1]) {
					int temp = arr[rptr-1];
					arr[rptr-1] = arr[rptr];
					arr[rptr] = temp;
					rptr--;
				}
			}
			
			System.out.printf("#%s %s\n", test_case, arr[99] - arr[0]);
		}
		sc.close();
	}
}

