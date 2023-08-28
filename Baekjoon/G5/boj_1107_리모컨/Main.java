//package boj_1107_리모컨;
//// https://stackoverflow.com/questions/1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//
//public class Main {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		
//		int C = 100;
//		int N = Integer.parseInt(bf.readLine());
//		String Nstring = String.valueOf(N);
//		int M = Integer.parseInt(bf.readLine());
//		Set<Integer> broken = M!=0 ? Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new)) : null;
//		
//		// 0. 숫자로 가는 것보다 위아래로만 조정하는 게 빠른 경우
//		if (N>=98 && N<=102) {
//			System.out.println(C-N);
//			return;
//		}
//		
//		// 1. 부서진 버튼이 없는 경우
//		if (broken == null) {
//			System.out.println(Nstring.length());
//			return;
//		}
//		
//		// 2. 숫자로 가장 가까이 간 후 위아래로 조정
//		int bigger = 0;
//		int smaller = 0;
//		
//		int firstDigit = Character.digit(Nstring.charAt(0), 10);
//		if (broken.contains(firstDigit)) {
//			int minNotBroken, maxNotBroken;
//			int down_ptr = 9;
//			int up_ptr = 0;
//			
//			while (down_ptr > 0) {
//				if (broken.contains(down_ptr)) {
//					down_ptr--;
//				} else {
//					maxNotBroken = down_ptr;
//					break;
//				}
//			}
//			while (up_ptr <= 9) {
//				if (broken.contains(up_ptr)) {
//					up_ptr++;
//				} else {
//					minNotBroken = up_ptr;
//					break;
//				}
//			}
//			
//			bigger += firstDigit * (int) Math.pow(10, Nstring.length()-1);
//			smaller += bigger;
//			for (int i=1; i<=Nstring.length()-1; i++) {
//				bigger += minNotBroken
//			}
//		} else {
//			
//		}
//		
//		for (int i=0; i<String.valueOf(N).length(); i++) {
//			int down_ptr, up_ptr;
//			int digit = Character.digit(String.valueOf(N).charAt(i), 10);
//
//			
//			
//			if (broken.contains(digit))
//			
//			
//			if (i==0) {
//				// 첫째자리 결정
//				down_ptr = firstDigit;
//				up_ptr = firstDigit;
//			} else {
//				// 나머지 자리수 결정
//				down_ptr = 9;
//				up_ptr = 0;
//			}
//			
//			while (down_ptr > 0) {
//				if (broken.contains(down_ptr)) {
//					down_ptr--;
//				} else {
//					smaller += String.valueOf(down_ptr);
//					break;
//				}
//			}
//			while (up_ptr <= 9) {
//				if (broken.contains(up_ptr)) {
//					up_ptr++;
//				} else {
//					bigger += String.valueOf(up_ptr);
//					break;
//				}
//			}
//			
//			System.out.println("bigger: "+bigger);
//			System.out.println("smaller: "+smaller);
//		}
//		
//		int numTyping, upDownTyping;
//		if (Math.abs(Integer.parseInt(bigger)-N) < Math.abs(Integer.parseInt(smaller)-N)) {
//			numTyping = bigger.length();
//			upDownTyping = Math.abs(Integer.parseInt(bigger)-N);
//		} else {
//			numTyping = smaller.length();
//			upDownTyping = Math.abs(Integer.parseInt(smaller)-N);
//		}
//		
//		System.out.println(numTyping + upDownTyping);
//	}
//}
