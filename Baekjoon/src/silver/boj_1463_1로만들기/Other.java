package silver.boj_1463_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Other {
	public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        System.out.println(re(n,0));
    }
    private static int re(int n,int count){
        if(n < 2)
            return count;
        count++;
        return Math.min(re(n/2,count+n%2),re(n/3,count+n%3));
    }
}
