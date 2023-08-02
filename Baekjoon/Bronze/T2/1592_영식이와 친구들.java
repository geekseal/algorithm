import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] count = {0, 0, 0, 0, 0};
		
		int cur = 0;
		int ptr = 0;
		int answer = 0;
		while (cur != M) {
			count[ptr] += 1;
			
			if (count[ptr] % 2 == 1) {
				ptr = (ptr + L) % N;
			} else {
				ptr = (ptr + (N - L)) % N;
			}
			
			answer += 1;
			cur = count[ptr];
		}
		
		System.out.println(answer);
		sc.close();
	}
}

