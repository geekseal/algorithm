package permutation;

import java.util.Arrays;

public class Bitmasking {
	public static int[] nums;// 배열
	public static int N; // 원소수
	public static int[] result; // 결과저장

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2};
//		nums = new int[] { 0, 1, 1, 2}; 이렇게 중복된 값이 있으면 또나와~ 이것을 거르는 방법을 연구해보시오.
		//next_permutation 방법이 있다.(나아아아아중에 이런것들이 익숙해지고 난뒤 한번 보면 좋다)
		N = nums.length;
		result = new int[N];
		perm(0, 0);
	}
	//idx 현재 내가 판단하는 위치
	public static void perm(int idx, int visited) {
//		다른식으로 작성가능한가?
//		if(visited == (1<<N)-1) //이 표현에 N개의 비트가 1로 가득차있는 상태이다.
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		//사용할 수 있는 모든 원소를 쳌 하겠다.
		for(int i = 0 ; i<N; i++) {
			//해당 원소 썼니? 
			if((visited & (1<<i)) > 0) continue;
			result[idx] = nums[i]; //결과저장
			perm(idx+1, visited | (1<<i));
		}
		
	}
	
}