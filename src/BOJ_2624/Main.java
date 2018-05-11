package BOJ_2624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static int T;
    static int K;
    static int[][] coin;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(reader.readLine());
        K = Integer.parseInt(reader.readLine());

        coin = new int[K+1][2];
        dp = new int[K+1][T + 1];

        for (int i = 1; i <= K; i++) {
            String[] input = reader.readLine().split(" ");
            coin[i][0] = Integer.parseInt(input[0]);
            coin[i][1] = Integer.parseInt(input[1]);
        }

        dp[0][0] = 1;

        for (int i = 1; i <= K; i++) {//동전 종류
            for (int k = 0; k <= coin[i][1]; k++) {// 동전 갯수
                for(int j=0; j<=T; j++){//금액 계산
                    if(j+coin[i][0]*k>T)
                        break;
                    dp[i][j+coin[i][0]*k]+=dp[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[K][T]);
    }
}
