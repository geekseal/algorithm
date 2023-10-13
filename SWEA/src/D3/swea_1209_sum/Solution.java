package D3.swea_1209_sum;
// https://stackoverflow.com/questions/47976489/difference-between-optionalint-and-int
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("D3/swea_1209_sum/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++)
		{
			int test_case = Integer.parseInt(sc.nextLine());
			int[][] arr = new int[100][100];
			
			// row100 + col100 + cross2
			int[] max = new int[202];
			
			for (int r=0; r<100; r++) {
				arr[r] = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for (int r=0; r<100; r++) {
				for (int c=0; c<100; c++) {
					// row sum
					max[r] += arr[r][c];
					
					// column sum
					max[100+c] += arr[r][c];
					
					// cross sum
					if (r==c) max[200] += arr[r][c];
					if (r+c==99) max[201] += arr[r][c];
				}
			}
			
			System.out.printf("#%d %d\n", test_case, Arrays.stream(max).max().getAsInt());
		}
		sc.close();
	}
}