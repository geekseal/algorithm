package swea_11315_오목판정;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("D3/swea_11315_오목판정/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T; t++)
		{
			int N = sc.nextInt();
			int skip = 0;
			sc.nextLine();
			boolean isOmok = false;
			int[] vertical = new int[N];
			int[] leftDownCross = new int[N + (N-5)];
			int[] rightDownCross = new int[2*N-9];
			
			// 입력 받는 동시에 해결하고 싶었음
			finishIter:
			for (int r=0; r<N; r++) {
				int horizontal = 0;
				
				String line = sc.nextLine();
				for (int c=0; c<N; c++) {
					if (line.charAt(c) == 'o') {
						if (++horizontal == 5 || ++vertical[c] == 5) {
							isOmok = true;
							skip = N-r-1;
							break finishIter;
						}
						if (r+c>=4 && r+c<=(N-1)+(N-5) && ++leftDownCross[r+c] == 5) {
							isOmok = true;
							skip = N-r-1;
							break finishIter;
						}
						if (r-c>=-(N-5) && r-c<=N-5 && ++rightDownCross[r-c<0 ? rightDownCross.length + (r-c) : r-c] == 5) {
							isOmok = true;
							skip = N-r-1;
							break finishIter;
						}
					} else {
						horizontal = 0;
						vertical[c] = 0;
						if (r+c>=4 && r+c<=(N-1)+(N-5)) leftDownCross[r+c] = 0;
						if (r-c>=-(N-5) && r-c<=N-5) rightDownCross[r-c<0 ? rightDownCross.length + (r-c) : r-c] = 0;
					}
				}
			}
			
			if (isOmok) {
				System.out.printf("#%d YES\n", t);
				for (int i=0; i<skip; i++) {
					sc.nextLine();
				}
			} else {
				System.out.printf("#%d NO\n", t);
			}
			
		}
		
	}
}