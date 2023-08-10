package boj_1074_Z;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("S1/boj_1074_Z/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, r, c;
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int sr, er, sc, ec;
		sr = 0;
		er = (int) Math.pow(2, N) - 1;
		sc = 0;
		ec = er;
		
		int answer = -1;
		
		while (N >= 0) {
			if (N==0) {
				answer++;
				break;
			}
			
			int midr, midc;
			midr = (sr+er)/2;
			midc = (sc+ec)/2;
			
			// first, second quarter
			if (r <= midr) {
				er = midr;
				if (c <= midc) {
					ec = midc;
				} else {
					sc = midc+1;
					answer += Math.pow(4, N-1);
				}	
			}
			
			// third, fourth quarter
			else {
				sr = midr+1;
				
				if (c <= midc) {
					ec = midc;
					answer += 2*Math.pow(4, N-1);
				} else {
					sc = midc+1;
					answer += 3*Math.pow(4, N-1);
				}
			}
			
			N--;
		}
		
		System.out.println(answer);
	}
}
