package gold_4.boj_20056_마법사상어와파이어볼;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Fireball>[][] arr;
	static int N;
	static class D {
		int dr, dc;

		public D(int dr, int dc) {
			super();
			this.dr = dr;
			this.dc = dc;
		}
	}
	
	static D[] dmap = new D[] {
		new D(-1, 0),
		new D(-1, 1),
		new D(0, 1),
		new D(1, 1),
		new D(1, 0),
		new D(1, -1),
		new D(0, -1),
		new D(-1, -1)
	};
	
	static class Fireball {
		int r, c, m, s, d;

		public Fireball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public int getM() {
			return m;
		}

		public void setM(int m) {
			this.m = m;
		}

		public int getS() {
			return s;
		}

		public void setS(int s) {
			this.s = s;
		}

		public int getD() {
			return d;
		}

		public void setD(int d) {
			this.d = d;
		}
	}
	
	static void command() {
		//get list of current fireballs
		List<Fireball> fbList = new ArrayList<>();
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				for (Fireball fb : arr[r][c]) {
					fbList.add(fb);
				}
			}
		}
		
		//1.move
		for (Fireball fb : fbList) {
			int nr, nc;
			nr = (fb.r + (dmap[fb.d].dr) * fb.s) % N;
			nc = (fb.c + (dmap[fb.d].dc) * fb.s) % N;
			
			if (nr < 0) nr = N+nr;
			if (nc < 0) nc = N+nc;
			
			arr[nr][nc].add(new Fireball(nr, nc, fb.m, fb.s, fb.d));
		}
		
		//1-1.remove
		for (Fireball fb : fbList) {
			arr[fb.r][fb.c].remove(fb);
		}
		
		//2.join
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				if (arr[r][c].size() >= 2) {
					// calculate new m, new s
					int nm, ns;
					nm = (int) arr[r][c].stream().mapToInt(fb->fb.getM()).sum() / 5;
					ns = (int) arr[r][c].stream().mapToInt(fb->fb.getS()).average().getAsDouble();
					
					// check if all d is odd or even numbers
					boolean isAllOddOrEven;
					isAllOddOrEven = arr[r][c].stream().allMatch(fb->fb.getD()%2==0) || arr[r][c].stream().allMatch(fb->fb.getD()%2==1);
					
					// first, remove all
					arr[r][c].clear();
					
					// do not create new fireballs if new m is 0
					if (nm==0) continue;
					
					// than create new 4 fireballs
					for (int i=0; i<8; i+=2) {
						arr[r][c].add(new Fireball(r, c, nm, ns, isAllOddOrEven ? i : i+1));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M, K;
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		arr = new ArrayList[N][N];
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				arr[r][c] = new ArrayList<Fireball>();
			}
		}
		
		for (int i=0; i<M; i++) {
			int r, c, m, s, d;
			r = sc.nextInt()-1;
			c = sc.nextInt()-1;
			m = sc.nextInt();
			s = sc.nextInt();
			d = sc.nextInt();
			arr[r][c].add(new Fireball(r, c, m, s, d));
		}
		
		for (int i=0; i<K; i++) {
			command();
		}
		
		int ans = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				for (Fireball fb : arr[r][c]) {
					ans += fb.m;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
