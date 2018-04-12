package BOJ_2293;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        List<Integer> coin = new ArrayList<>();
        for(int i=0; i<n; i++){
            coin.add(Integer.parseInt(reader.readLine()));
        }

        int result = solve(coin,k);
        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(List<Integer> coin, int k){
        int[] dp = new int[k+1];

        dp[0] = 1;

        for(int i=0 ;i<coin.size(); i++){
            for(int j=coin.get(i); j<k+1; j++){
                dp[j] += dp[j-coin.get(i)];
            }
        }

        return dp[k];
    }
}
