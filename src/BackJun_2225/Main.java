package BackJun_2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int K;
    static long[][] dp;
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = reader.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);
        dp = new long[N+1][K+1];

        for(int i=0; i<N+1; i++)
            dp[i][1] = 1;

        for(int k=2; k<K+1; k++){
            for(int i=0; i<N+1; i++){
                for(int j=0; j<=i; j++){
                    dp[i][k]=(dp[i][k]+dp[j][k-1])%MOD;
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}