package gold.boj_1655_가운데를말해요;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<N; i++) {
			int n = sc.nextInt();
			
			if (left.size()==0 && right.size()==0) {
				left.offer(n);
				sb.append(left.peek()+"\n");
				continue;
			}
			
			if (left.size()==right.size()) {
				if (n<right.peek()) {
					left.offer(n);
					sb.append(left.peek()+"\n");
					continue;
				} else {
					right.offer(n);
					sb.append(right.peek()+"\n");
					continue;
				}
			}
			else if (left.size() > right.size()) {
				if (n>left.peek()) {
					right.offer(n);
					sb.append(left.peek()+"\n");
					continue;
				} else {
					left.offer(n);
					right.offer(left.poll());
					sb.append(left.peek()+"\n");
					continue;
				}
			} else {
				if (n<right.peek()) {
					left.offer(n);
					sb.append(left.peek()+"\n");
					continue;
				} else {
					right.offer(n);
					left.offer(right.poll());
					sb.append(left.peek()+"\n");
					continue;
				}
			}
			
		}
		System.out.println(sb);
		sc.close();
	}

}
