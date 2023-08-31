package merge_sort;

import java.util.Arrays;

public class MergeSort {
	static public void mergeSort(int[] S) {
		int n = S.length;
		if (n == 1) return;
		
		int mid = n/2;

		int[] S1 = Arrays.copyOfRange(S, 0, mid);
		int[] S2 = Arrays.copyOfRange(S, mid, n);
		
		mergeSort(S1);
		mergeSort(S2);
		
		merge(S1, S2, S);
	}
	
	static public void merge(int[] s1, int[] s2, int[] s) {
		int i, j, n;
		i = 0;
		j = 0;
		n = s.length;
		
		while (i+j<n) {
			if (i==s1.length) {
				s[i+j] = s2[j];
				j++;
			} else if (j==s2.length) {
				s[i+j] = s1[i];
				i++;
			} else {
				if (s1[i] < s2[j]) {
					s[i+j] = s1[i];
					i++;
				} else {
					s[i+j] = s2[j];
					j++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {4, 8, 3, 6, 1};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}