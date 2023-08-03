import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int extra = -100;
		
		for (int i = 0; i < 9; i++) {
			int num = sc.nextInt();
			arr.add(num);
			extra += num;
		}
				
		outer:
		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				if (arr.get(i) + arr.get(j) == extra) {
					arr.remove(j);
					arr.remove(i);
					break outer;
				}
			}
		}
		
		Collections.sort(arr);
		
		for (int num : arr) {
			System.out.println(num);
		}
		
		sc.close();
	}
}
