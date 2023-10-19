package platinum.boj_5373_큐빙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final char w= 119;
	static final char y= 121;
	static final char r= 114;
	static final char o= 111;
	static final char g= 103;
	static final char b= 98;
	static final char U= 85;
	static final char D= 68;
	static final char F= 70;
	static final char B= 66;
	static final char L= 76;
	static final char R= 82;
	static final char PLUS= 43;
	static final char MINUS= 45;
	static char[][] up = new char[3][3];
	static char[][] down = new char[3][3];
	static char[][] front = new char[3][3];
	static char[][] back = new char[3][3];
	static char[][] left = new char[3][3];
	static char[][] right = new char[3][3];
	
	static void turn(char side, char dir) {
		switch (side) {
		// u1 done
		case U:
			if (dir == PLUS) {
				char[] temp = new char[] {left[0][0], left[0][1], left[0][2]};
				for (int i=0; i<3; i++) {
					left[0][i] = front[0][2-i];
					front[0][2-i] = right[0][2-i];
					right[0][2-i] = back[0][i];
					back[0][i] = temp[i];
				}
				
				//해당 면도 수정해줘야 함
				temp = new char[] {up[0][0], up[0][1]};
				for (int i=0; i<2; i++) {
					up[0][i] = up[2-i][0];
					up[2-i][0] = up[2][2-i];
					up[2][2-i] = up[i][2];
					up[i][2] = temp[i];
				}
			} else {
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {left[0][0], left[0][1], left[0][2]};
					for (int i=0; i<3; i++) {
						left[0][i] = front[0][2-i];
						front[0][2-i] = right[0][2-i];
						right[0][2-i] = back[0][i];
						back[0][i] = temp[i];
					}
				}
				
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {up[0][0], up[0][1]};
					for (int i=0; i<2; i++) {
						up[0][i] = up[2-i][0];
						up[2-i][0] = up[2][2-i];
						up[2][2-i] = up[i][2];
						up[i][2] = temp[i];
					}
				}
			}
			break;
			
		// d1 done
		case D:
			if (dir == PLUS) {
				char[] temp = new char[] {left[2][0], left[2][1], left[2][2]};
				for (int i=0; i<3; i++) {
					left[2][i] = back[2][i];
					back[2][i] = right[2][2-i];
					right[2][2-i] = front[2][2-i];
					front[2][2-i] = temp[i];
				}
				
				for (int k=0; k<3; k++) {
					temp = new char[] {down[0][0], down[0][1]};
					for (int i=0; i<2; i++) {
						down[0][i] = down[2-i][0];
						down[2-i][0] = down[2][2-i];
						down[2][2-i] = down[i][2];
						down[i][2] = temp[i];
					}
				}
			} else {
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {left[2][0], left[2][1], left[2][2]};
					for (int i=0; i<3; i++) {
						left[2][i] = back[2][i];
						back[2][i] = right[2][2-i];
						right[2][2-i] = front[2][2-i];
						front[2][2-i] = temp[i];
					}
				}
				char[] temp = new char[] {down[0][0], down[0][1]};
				for (int i=0; i<2; i++) {
					down[0][i] = down[2-i][0];
					down[2-i][0] = down[2][2-i];
					down[2][2-i] = down[i][2];
					down[i][2] = temp[i];
				}
			}
			break;
		// f1 done
		case F:
			if (dir == PLUS) {
				char[] temp = new char[] {left[0][0], left[1][0], left[2][0]};
				for (int i=0; i<3; i++) {
					left[i][0] = down[2][i];
					down[2][i] = right[2-i][0];
					right[2-i][0] = up[2][2-i];
					up[2][2-i] = temp[i];
				}
				temp = new char[] {front[0][0], front[0][1]};
				for (int i=0; i<2; i++) {
					front[0][i] = front[2-i][0];
					front[2-i][0] = front[2][2-i];
					front[2][2-i] = front[i][2];
					front[i][2] = temp[i];
				}
				
			} else {
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {left[0][0], left[1][0], left[2][0]};
					for (int i=0; i<3; i++) {
						left[i][0] = down[2][i];
						down[2][i] = right[2-i][0];
						right[2-i][0] = up[2][2-i];
						up[2][2-i] = temp[i];
					}
				}
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {front[0][0], front[0][1]};
					for (int i=0; i<2; i++) {
						front[0][i] = front[2-i][0];
						front[2-i][0] = front[2][2-i];
						front[2][2-i] = front[i][2];
						front[i][2] = temp[i];
					}
				}
			}
			break;
		// b1 done
		case B:
			if (dir == PLUS) {
				char[] temp = new char[] {left[0][2], left[1][2], left[2][2]};
				for (int i=0; i<3; i++) {
					left[i][2] = up[0][2-i];
					up[0][2-i] = right[2-i][2];
					right[2-i][2] = down[0][i];
					down[0][i] = temp[i];
				}
				for (int k=0; k<3; k++) {
					temp = new char[] {back[0][0], back[0][1]};
					for (int i=0; i<2; i++) {
						back[0][i] = back[2-i][0];
						back[2-i][0] = back[2][2-i];
						back[2][2-i] = back[i][2];
						back[i][2] = temp[i];
					}
				}
			} else {
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {left[0][2], left[1][2], left[2][2]};
					for (int i=0; i<3; i++) {
						left[i][2] = up[0][2-i];
						up[0][2-i] = right[2-i][2];
						right[2-i][2] = down[0][i];
						down[0][i] = temp[i];
					}
				}
				char[] temp = new char[] {back[0][0], back[0][1]};
				for (int i=0; i<2; i++) {
					back[0][i] = back[2-i][0];
					back[2-i][0] = back[2][2-i];
					back[2][2-i] = back[i][2];
					back[i][2] = temp[i];
				}
			}
			break;
		// l1 done
		case L:
			if (dir == PLUS) {
				char[] temp = new char[] {back[0][0], back[1][0], back[2][0]};
				for (int i=0; i<3; i++) {
					back[i][0] = down[i][0];
					down[i][0] = front[2-i][0];
					front[2-i][0] = up[2-i][0];
					up[2-i][0] = temp[i];
				}
				for (int k=0; k<3; k++) {
					temp = new char[] {left[0][0], left[0][1]};
					for (int i=0; i<2; i++) {
						left[0][i] = left[2-i][0];
						left[2-i][0] = left[2][2-i];
						left[2][2-i] = left[i][2];
						left[i][2] = temp[i];
					}
				}
			} else {
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {back[0][0], back[1][0], back[2][0]};
					for (int i=0; i<3; i++) {
						back[i][0] = down[i][0];
						down[i][0] = front[2-i][0];
						front[2-i][0] = up[2-i][0];
						up[2-i][0] = temp[i];
					}
				}
				char[] temp = new char[] {left[0][0], left[0][1]};
				for (int i=0; i<2; i++) {
					left[0][i] = left[2-i][0];
					left[2-i][0] = left[2][2-i];
					left[2][2-i] = left[i][2];
					left[i][2] = temp[i];
				}
			}
			break;
		// r1 done
		case R:
			if (dir == PLUS) {
				char[] temp = new char[] {back[0][2], back[1][2], back[2][2]};
				for (int i=0; i<3; i++) {
					back[i][2] = up[2-i][2];
					up[2-i][2] = front[2-i][2];
					front[2-i][2] = down[i][2];
					down[i][2] = temp[i];
				}
				temp = new char[] {right[0][0], right[0][1]};
				for (int i=0; i<2; i++) {
					right[0][i] = right[2-i][0];
					right[2-i][0] = right[2][2-i];
					right[2][2-i] = right[i][2];
					right[i][2] = temp[i];
				}
			} else {
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {back[0][2], back[1][2], back[2][2]};
					for (int i=0; i<3; i++) {
						back[i][2] = up[2-i][2];
						up[2-i][2] = front[2-i][2];
						front[2-i][2] = down[i][2];
						down[i][2] = temp[i];
					}
				}
				for (int k=0; k<3; k++) {
					char[] temp = new char[] {right[0][0], right[0][1]};
					for (int i=0; i<2; i++) {
						right[0][i] = right[2-i][0];
						right[2-i][0] = right[2][2-i];
						right[2][2-i] = right[i][2];
						right[i][2] = temp[i];
					}
				}
			}
			break;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		for (int tc=0; tc<T; tc++) {
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					up[i][j] = w;
					down[i][j] = y;
					front[i][j] = r;
					back[i][j] = o;
					left[i][j] = g;
					right[i][j] = b;
				}
			}
			
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int n=0; n<N; n++) {
				String command = st.nextToken();
				turn(command.charAt(0), command.charAt(1));
			}

			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					ans.append(up[i][j]);
				}
				ans.append(System.lineSeparator());
			}
		}
		//아래 줄 없애야 맞음..
//		ans.delete(ans.length()-2, ans.length());
		System.out.print(ans);
	}
}

