package swea_5356_의석이의세로로말해요;

import java.util.ArrayList;
import java.util.Scanner;
	
class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			ArrayList<String> list = new ArrayList<String>();
			
			for (int i=0; i<5; i++) {
				String[] chars = sc.nextLine().split("");
				for (int j=0; j<chars.length; j++) {
					try {
						list.set(j, list.get(j) + chars[j]);
					} catch (IndexOutOfBoundsException e) {
						list.add(chars[j]);
					}
				}
			}
			
			String answer = "";
			
			for (String str: list) {
				answer += str;
			}
			System.out.printf("#%s %s\n", test_case, answer);
			
		}
		sc.close();
	}
}