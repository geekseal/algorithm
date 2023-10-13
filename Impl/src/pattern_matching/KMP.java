package pattern_matching;

public class KMP {
	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
		
		
		kmp(text, pattern);
	}

	// 실패함수 getPi()
	public static int[] getPi(String pt) {
		// 접두사와 접미사가 일치하는 최대길이를 담은 배열
		int[] pi = new int[pt.length()]; // 0~i까지의 부분 문자열에서 접두사와 접미사 일치하는 길을 담겠다.

		int j = 0; // 현재 여기까지는 같아요~~
		// i, j가 가리키는 값이 같다면 둘다 증가
		// i는 무조건 증가
		for (int i = 1; i < pt.length(); i++) {
			// 두포인트가 다르다면
			while (j > 0 && pt.charAt(i) != pt.charAt(j)) {
				j = pi[j - 1];
			}

			// 두포인트가 같다면
			if (pt.charAt(i) == pt.charAt(j))
				pi[i] = ++j; // i버쨰의 최대길이는 ++j값을 저장하겠다.
		}

		return pi;
	}
	
	public static void kmp(String text, String pt) {
		int[] pi = getPi(pt); //점프테이블 가져와
		
		int j = 0; //패턴 내에서 움직이는 인덱스
		//i:본문의 인덱스
		for(int i = 0 ; i<text.length(); i++) {
			//실패했다. 점푸
			while(j > 0 && text.charAt(i) != pt.charAt(j))
				j = pi[j-1];
			
			//내가 보고 있는 패턴위치와 텍스트의 값이 동일 하다면
			if(text.charAt(i) == pt.charAt(j)) {
				if(j == pt.length()-1) {
					//패턴찾았다.
					System.out.println((i-j)+"패턴을 찾았습니다.");
					System.out.println((i-pt.length()+1)+"패턴");
				}else {
					//다 찾은게 아니라면 계속 진행시켜
					j++;
				}
			}
		}
		
	}
	
}