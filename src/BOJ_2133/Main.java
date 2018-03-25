package BOJ_2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        dp = new long[N+1];

        if(N==1) {
            System.out.println(0);
            return ;
        }

        dp[0]=1;
        dp[1]=0;
        dp[2]=3;

        for(int i=4; i<N+1; i++){
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; j <= i; j += 2)
                dp[i] += dp[i - j] * 2;
        }

        System.out.println(dp[N]);
    }
}
