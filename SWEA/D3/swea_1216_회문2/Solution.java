package swea_1216_회문2;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
	static boolean isPalindrome(String string) {
		for (int i=0; i<string.length()/2; i++) {
			if (string.charAt(i) != string.charAt(string.length()-1-i)) return false;
		}
		return true;
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("D3/swea_1216_회문2/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int t=0; t<10; t++) {
			int test_case = Integer.parseInt(sc.nextLine());
			
			// initialize array
			String[] arr = new String[100];
			for (int i=0; i<100; i++) {
				arr[i] = sc.nextLine().trim();
			}
			
			// initialize rotated array
			String[] rotatedArr = new String[100];
			for (int i=0; i<100; i++) {
				char[] chars = new char[100];
				for (int j=0; j<100; j++) {
					chars[j] = arr[j].charAt(i);
				}
				rotatedArr[i] = String.valueOf(chars);
			}
			// solve problem
			int maxLength = 1;
			outer:
			for (int length=100; length>1; length--) {
				for (int row=0; row<100; row++) {
					for (int i=0; i<=100-length; i++) {
						// check horizontal and vertical at the same time
						if (isPalindrome(arr[row].substring(i, i+length)) || isPalindrome(rotatedArr[row].substring(i, i+length))) {
							maxLength = length;
							break outer;
						}
					}
				}
				
			}
			System.out.printf("#%d %d\n", test_case, maxLength);
		} // test case end
		sc.close();
	}
}