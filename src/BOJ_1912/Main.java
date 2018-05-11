package BOJ_1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] arr;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        arr = new long[N];
        dp = new long[N];

        String[] input = reader.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        dp[0] = arr[0];

        for(int i=1; i<N; i++){
            dp[i] = Math.max(arr[i]+dp[i-1],arr[i]);
        }

        long max = Integer.MIN_VALUE;
        for(int i=0; i<N;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
