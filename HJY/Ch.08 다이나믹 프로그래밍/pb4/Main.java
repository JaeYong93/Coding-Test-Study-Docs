import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[m+1];
        Arrays.fill(dp, 10001);

        dp[0] = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = arr[i] ; j <= m ; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]]+1);
            }
        }

        if(dp[m] == 10001) {
            System.out.println(-1);
        } else {
             System.out.println(dp[m]);   
        }
    }
}
