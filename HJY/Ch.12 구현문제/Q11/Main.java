import java.util.*;

//이동 정보를 저장하는 클래스
class Node {

    private int time;
    private char direction;

    public Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection() {
        return this.direction;
    }
}

//위치를 저장하는 클래스
class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class Main {

    public static int n, k, l;
    public static int[][] arr = new int[101][101];
    public static ArrayList<Node> info = new ArrayList<>();

    //방향 설정(처음에는 동쪽으로 이동하기 때문에 동,남,서,북 순서)
    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int turn(int direction, char c) {
        if(c == 'L') direction = (direction==0) ? 3 : direction - 1; 
        else direction = (direction+1) % 4;
        return direction;
    }

    public static int simulate() {
        int x = 1, y = 1;

        //뱀이 위치하는 곳은 2로 표시
        arr[x][y] = 2;
        int direction = 0;
        int time = 0;

        //다음에 회전할 정보
        int index = 0;

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x,y));

        while(true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2) {
                if(arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                } 

                if(arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                } 
            } else {
                time += 1;
                break;
            }

            x = nx;
            y = ny;
            time +=1;
            if(index < l && time == info.get(index).getTime()) {
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0 ; i < k ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        l = sc.nextInt();

        for(int i = 0 ; i < l ; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }
        System.out.println(simulate());
    }
}
