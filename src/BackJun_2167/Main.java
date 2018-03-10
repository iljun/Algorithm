package BackJun_2167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        arr = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for(int i=1; i<N+1; i++){
            String[] tmp = reader.readLine().split(" ");
            for(int j=1; j<M+1; j++){
                arr[i][j] = Integer.parseInt(tmp[j-1]);
                dp[i][j] = arr[i][j] + dp[i][j-1];
            }
        }



        StringBuilder builder = new StringBuilder();

        K = Integer.parseInt(reader.readLine());
        for(int z=0; z<K; z++){
            String[] tmp = reader.readLine().split(" ");
            int i = Integer.parseInt(tmp[0]);
            int j = Integer.parseInt(tmp[1]);
            int x = Integer.parseInt(tmp[2]);
            int y = Integer.parseInt(tmp[3]);

            int result = 0;
            for(int row = i ; row<=x; row++){
                result += dp[row][y] - dp[row][j-1];
            }
            builder.append(result).append("\n");

        }
        System.out.println(builder.toString());
    }
}
