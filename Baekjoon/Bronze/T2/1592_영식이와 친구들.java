import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		sc.close();
		
		int[] count = new int[N];
		
		int ptr = 0;
		int answer = 0;
		
		while (count[ptr] != M) {
			count[ptr] += 1;
			if (count[ptr] == M) break;
			
			if (count[ptr] % 2 == 1) {
				ptr = (ptr + L) % N;
			} else {
				ptr = (ptr + (N - L)) % N;
			}
			
			answer += 1;
		}
		
		System.out.println(answer);
		
	}
}
