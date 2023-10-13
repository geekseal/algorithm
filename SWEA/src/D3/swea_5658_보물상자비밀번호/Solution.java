package D3.swea_5658_보물상자비밀번호;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("D3/swea_5658_보물상자비밀번호/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N, K;
			N = sc.nextInt();
			K = sc.nextInt();
			String nums = sc.next();
			TreeSet<Integer> set = new TreeSet<Integer>();
			
			// initialize queue
			Queue<String> q = new LinkedList<>();
			for (String num : nums.split("")) {
				q.add(num);
			}
			
			// slicing by size N/4, then add polled one to last
			for (int i=0; i<N/4; i++) {
				if (i != 0) {
					q.add(q.poll());
				}
				for (int j=0; j<N; j+=N/4) {
					set.add(Integer.parseInt(String.join("", q.stream().skip(j).limit(N/4).collect(Collectors.toList())), 16));
				}
			}
			
			System.out.printf("#%s %s\n", test_case, set.toArray()[set.size() - K]);
		}
		
		sc.close();
	}
}