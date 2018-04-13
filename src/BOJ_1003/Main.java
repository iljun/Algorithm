package BOJ_1003;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        int[][] dp = new int[2][41];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<41; i++){
            dp[0][i] = dp[0][i-2] + dp[0][i-1];
            dp[1][i] = dp[1][i-2] + dp[1][i-1];
        }

        while(t-->0){
            int n = Integer.parseInt(reader.readLine());
            writer.write(String.valueOf(dp[0][n]) + " " + String.valueOf(dp[1][n])+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}
