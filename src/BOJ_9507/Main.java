package BOJ_9507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp = new long[69];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<69; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
        }

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(reader.readLine());

            System.out.println(dp[input]);
        }
    }
}
