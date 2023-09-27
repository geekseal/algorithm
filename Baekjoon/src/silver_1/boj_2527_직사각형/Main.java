package silver_1.boj_2527_직사각형;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc=0; tc<4; tc++) {
			int x1, p1, y1, q1, x2, p2, y2, q2, w1, h1, w2, h2;
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			p1 = sc.nextInt();
			q1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			p2 = sc.nextInt();
			q2 = sc.nextInt();
			
			w1 = p1 - x1;
			h1 = q1 - y1;
			w2 = p2 - x2;
			h2 = q2 - y2;
			
			int minX, maxX, minY, maxY;
			minX = Math.min(x1, x2);
			maxX = Math.max(p1, p2);
			minY = Math.min(y1, y2);
			maxY = Math.max(q1, q2);
			
			// case a : rectangle
			if ((maxX-minX < w1+w2) && (maxY-minY < h1+h2)) {
				System.out.println("a");
				continue;
			}
			
			// case b : line
			if ((maxX-minX == w1+w2) && (maxY-minY < h1+h2)) {
				System.out.println("b");
				continue;
			} else if ((maxX-minX < w1+w2) && (maxY-minY == h1+h2)) {
				System.out.println("b");
				continue;
			}
			
			// case c : dot
			if ((maxX-minX == w1+w2) && (maxY-minY == h1+h2)) {
				System.out.println("c");
				continue;
			}
			
			// case d : none
			System.out.println("d");
		}
		sc.close();
	}
}
