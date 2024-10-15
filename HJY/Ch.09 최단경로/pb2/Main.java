import java.util.*;
import java.lang.*;
import java.io.*;

class Node implements Comparable<Node> {
    
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    //거리가 짧은 것부터 우선순위 설정
    @Override
    public int compareTo(Node other) {
        if(this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
public class Main {

    public static final int INF = (int)1e9;

    //노드의 개수 n, 간선의 개수 m , 시작 노드 start
    public static int n, m, start;

    //그래프 정보 저장할 리스트 생성
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    
    //최단 거리 테이블 생성
    public static int[] d = new int[30001];

    //다익스트라 알고리즘 구현
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        //시작 노드로 가는 최단 경로는 0으로 설정
        pq.offer(new Node(start, 0));
        d[start] = 0;

        //큐가 비어있지 않을 경우
        while (!pq.isEmpty()) {
            Node node = pq.poll(); //최단 거리가 가장 짧은 노드 정보 꺼내기
            int dist = node.getDistance(); 
            int now = node.getIndex();
            
            //현재 노드가 이미 처리된 적 있으면 무시하고 계속
            if(d[now] < dist) {
                continue;
            }

            //현재 노드와 연결된 다른 노드 확인
            for (int i = 0 ; i < graph.get(now).size() ; i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
                
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //그래프 초기화
        for(int i = 0 ; i <= n ; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        //모든 간선 정보 입력
        for(int i = 0 ; i < m ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph.get(x).add(new Node(y,z));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        int count = 0;

        int maxDistance = 0;

        for(int i = 1 ; i <= n ; i++) {
            if(d[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }
        
        System.out.println((count - 1) + " "+ maxDistance);
    }
}
