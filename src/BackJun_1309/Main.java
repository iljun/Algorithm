package BackJun_1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] dp = new int[100001][3];;
    static final int MOD = 9901;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        for(int i=1; i<N; i++){
            dp[i][0] = (dp[i-1][0]+ dp[i-1][1]+dp[i-1][2])%MOD;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%MOD;
            dp[i][2] = (dp[i-1][0]+dp[i-1][1])%MOD;
        }

        int result=0;
        for(int i=0; i<3; i++){
            result+=dp[N-1][i];
            result%=MOD;
        }

        System.out.println(result);
    }
}
