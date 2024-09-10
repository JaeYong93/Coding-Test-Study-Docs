import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //가게의 부품 개수 및 번호 입력 받기
        int n = sc.nextInt();
        int[] arr = new int[1000001];
        for (int i = 0 ; i < n ; i++) {
            int x = sc.nextInt();
            arr[x] = 1;
        }

        //손님이 요청한 부품 개수 및 번호 입력 받기
        int m = sc.nextInt();
        int[] target = new int[n];
        for (int i = 0 ; i < m ; i++) {
            target[i] = sc.nextInt();
        }

        //계수 정렬 진행
        for (int i = 0 ; i < m ; i++) {
            if(arr[target[i]] == 1) {
                System.out.print("yes\s");
            } else {
                System.out.print("no\s");
            }
        }
    }
}
