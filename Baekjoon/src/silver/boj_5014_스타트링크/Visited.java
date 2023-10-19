package silver.boj_5014_스타트링크;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Visited {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //F층의 고층건물
        int F = sc.nextInt();
        //강호가 현재 있는 층
        int S = sc.nextInt();
        //스타트링크가 있는 층
        int G = sc.nextInt();
        
        int[] btn = new int[2];
        //U층 위로
        btn[0] = sc.nextInt();
        //D층 아래로
        btn[1] = sc.nextInt() * -1;
        
        bfs(F, S, G, btn);
        sc.close();
    }

    private static void bfs(int f, int s, int g, int[] btn) {
        int[] visited = new int[f+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        
        while(!q.isEmpty()) {
            int floor = q.poll();

            if(floor == g) {
                System.out.println(visited[g]);
                return;
            }
            
            for(int i = 0; i < 2; i++) {
                int nextF = floor + btn[i];
                if (nextF > 0 && nextF <= f && nextF != floor && visited[nextF] == 0) {
                    visited[nextF] = visited[floor] + 1;
                    q.add(nextF);
                }
            }
            
        }
        
        if(visited[g] == 0) {
            System.out.println("use the stairs");
        }
        
    }
}
