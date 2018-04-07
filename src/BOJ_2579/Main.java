package BOJ_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        dp = new int[N+1];
        arr = new int[N+1];

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }

        dp[1] = arr[1];
        dp[2] = Math.max(arr[2],arr[2]+arr[1]);

        for(int i=3; i<N+1; i++){
            dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i]+arr[i-1]);
        }

        System.out.println(dp[N]);
    }
}
