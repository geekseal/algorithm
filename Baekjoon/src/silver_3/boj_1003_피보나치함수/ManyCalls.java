package silver_3.boj_1003_피보나치함수;

//피보나치 함수
//메모리 초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManyCalls {
	// {zero, one}
	private static int[] fibo(int n) {
		if (n == 0) {
			return new int[] {1, 0};
		} else if (n == 1) {
			return new int[] {0, 1};
		}
		
		int arr[] = new int[2];
		
		int idx = 0;
		for (int v: fibo(n-1)) {
			arr[idx] += v;
			idx++;
		}
		
		idx = 0;
		for (int v: fibo(n-2)) {
			arr[idx] += v;
			idx++;
		}
		
		return arr;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()); 
		String answer = "";
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bf.readLine()); 
			int[] fibo = fibo(N);
			answer += String.format("%s %s%n", fibo[0], fibo[1]);
		}
		System.out.println(answer);
	}
}