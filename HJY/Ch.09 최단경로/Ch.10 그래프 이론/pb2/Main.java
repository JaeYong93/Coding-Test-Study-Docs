import java.util.*;
import java.lang.*;
import java.io.*;

class Edges implements Comparable<Edges> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edges(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    @Override
    public int compareTo(Edges other) {
        if(this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

class Main {

    public static int n, m;
    public static int[] parent = new int [100001];

    public static ArrayList<Edges> edges = new ArrayList<>();
    public static int result = 0;

    public static int findParent(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            edges.add(new Edges(cost, a, b));
        }

        Collections.sort(edges);
        int last = 0;

        for(int i = 0; i < edges.size() ; i++){
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            if(findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }
        System.out.println(result - last);
    }
}
