package BOJ_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for(int i=6; i<101; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(reader.readLine());
            System.out.println(dp[input]);
        }
    }
}
