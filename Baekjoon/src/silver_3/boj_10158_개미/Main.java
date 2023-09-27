package silver_3.boj_10158_개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		final int W, H;
		String[] wh = bf.readLine().split(" ");
		W = Integer.parseInt(wh[0]);
		H = Integer.parseInt(wh[1]);
		
		final int P, Q; // unchangeable
		int ansx, ansy; // changeable
		String[] pq = bf.readLine().split(" ");
		P = Integer.parseInt(pq[0]);
		Q = Integer.parseInt(pq[1]);
		ansx = P;
		ansy = Q;
		
		final int T; // unchangeable
		int xt, yt; // changeable
		T = Integer.parseInt(bf.readLine());
		xt = T;
		yt = T;

		// x
		if (xt <= W-P) {
			ansx += xt;
			xt = 0;
		} else { // 더 이상 순서가 중요하지 않게 됨.
			ansx = W;
			xt -= W-P;
		}
		
		xt %= 2*W;
		if (xt <= W) {
			ansx -= xt;
		} else {
			ansx -= W-(xt%W);
		}
		
		// y
		if (yt < H-Q) {
			ansy += yt;
			yt = 0;
		} else { // 더 이상 순서가 중요하지 않게 됨.
			yt -= H-Q;
			ansy = H;
		}
		
		yt %= 2*H;
		if (yt <= H) {
			ansy -= yt;
		} else {
			ansy -= H-(yt%H);
		}
		
		// print
		System.out.println(ansx+" "+ansy);
	}
}
