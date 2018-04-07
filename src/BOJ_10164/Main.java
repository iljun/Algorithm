package BOJ_10164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int K;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        dp = new long[N][M];

        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < M; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        if (K == 0) {
            System.out.println(dp[N - 1][M - 1]);
        } else {
            int x = (K-1) / M ;
            int y = (K-1) % M ;

            for(int i=x; i<N; i++){
                for(int j=y; j<M; j++){
                    if(i==x || j==y){
                        dp[i][j] = dp[x][y];
                    }else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }

            System.out.println(dp[N - 1][M - 1]);
        }

    }

}
