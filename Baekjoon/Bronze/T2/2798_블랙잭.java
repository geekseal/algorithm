import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		double answer = Double.NEGATIVE_INFINITY;
		
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					int total = arr[i] + arr[j] + arr[k];
					answer = total <= M && total > answer ? total : answer;
				}
			}
		}
		
		System.out.println((int) answer);
		
		sc.close();
	}
}