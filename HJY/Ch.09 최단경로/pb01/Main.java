import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static final int INF = (int)1e9;

    //노드의 개수 n, 간선의 개수 m, 거쳐갈 노드 x, 최종 목적지 k
    public static int n, m, x, k;

    //2차원 배열 설정
    public static int graph[][] = new int[101][101];
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        //최단 거리 테이블을 무한으로 초기화
        for (int i = 0 ; i < 101 ; i++){
            Arrays.fill(graph[i], INF);
        }

        //자기 자신에서 자기 자신으로 가는 값은 0으로 초기화
        for (int a = 1 ; a <= n  ; a++) {
            for(int b = 1 ; b <= n ; b++) {
                if(a==b) {
                    graph[a][b] = 0;
                }
            }
        }

        //각 간선에 대한 정보 입력 받고 값을 초기화
        for (int i = 0 ; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        //플로이드 워셜 알고리즘
        for(int k = 1 ; k <= n ; k++) {
            for(int a = 1 ; a <= n ; a++) {
                for(int b = 1 ; b <= n ; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
            
        }

        //수행된 거리 출력
        int distance = graph[1][k] + graph[k][x];

        if(distance >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);   
        }
    }
}
