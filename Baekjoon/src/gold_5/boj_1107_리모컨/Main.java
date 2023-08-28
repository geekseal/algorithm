package gold_5.boj_1107_리모컨;

//https://stackoverflow.com/questions/1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int C = 100;
		int N = Integer.parseInt(bf.readLine());
		String Nstring = String.valueOf(N);
		int M = Integer.parseInt(bf.readLine());
		Set<Integer> broken = M!=0 ? Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new)) : null;
		
		// 0. 숫자로 가는 것보다 위아래로만 조정하는 게 빠른 경우
		if (N>=98 && N<=102) {
			System.out.println(C-N);
			return;
		}
		
		// 1. 부서진 버튼이 없는 경우
		if (broken == null) {
			System.out.println(Nstring.length());
			return;
		}
		
		// 2. 숫자로 가장 가까이 간 후 위아래로 조정
		
	}
}