package quick_sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
	static void quickSort(int[] s, int start, int end) {
		if (start >= end) return;
		int l, r, p, pivot;
		l = start;
		r = end-1;
		// pick pivot and shift to the end of array.
		p = ThreadLocalRandom.current().nextInt(start, end+1);
		pivot = s[p];
		s[p] = s[end];
		s[end] = pivot;

		while (l <= r) {
			while (l <= r && s[l] < pivot) l++;
			while (l <= r && s[r] >= pivot) r--; // 한쪽이 무시하지 않으면 무한루프 돌 수 있음
			if (l <= r) {
				int temp = s[l];
				s[l] = s[r];
				s[r] = temp;
			}
		}
		int temp = s[l];
		s[l] = s[end];
		s[end] = temp;
		
		quickSort(s, start, l-1);
		quickSort(s, l+1, end);
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {4, 8, 3, 6, 1,1,2,3,45,0,7,6,4,4,454,2,0,5,4,3213,2,3,4,5,3,251};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
