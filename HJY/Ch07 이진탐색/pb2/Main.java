import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //떡의 개수와 요청한 떡의 길이 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        //떡의 높이
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = 1000000000;

        int result = 0;
        while(start <= end) {
            long total = 0;
            int mid = (start+end) / 2;

            for(int i = 0 ; i < n ; i++){
                if(arr[i] > mid) {
                    total += arr[i] - mid;
                }
            }
            if(total < m) {
                end = mid -1;
            } else {
                result = mid;
                start = mid+1;
            }
        }
        System.out.println(result);
    }
}
