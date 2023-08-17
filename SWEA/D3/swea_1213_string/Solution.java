package swea_1213_string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++)
		{
			int test_case = Integer.parseInt(sc.nextLine());
			Pattern pattern = Pattern.compile(sc.nextLine().trim());
			Matcher matcher = pattern.matcher(sc.nextLine().trim());
			
			int answer = 0;
			while (matcher.find()) answer++;
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}
}
