package BOJ_11051;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 23
 * Time: 오후 5:32
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        dp = new long[1001][1001];
        writer.write(solve(input));
        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(String[] input){
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        long result = choose(n,k);

        return String.valueOf(result);
    }
    static long[][] dp;

    public long choose(int n, int k){
        if(dp[n][k]>0)
            return dp[n][k];

        if(k==0 || n==k)
            return dp[n][k] = 1 % 10007;

        return dp[n][k] = (choose(n-1,k-1)% 10007 + choose(n-1,k)% 10007)%10007;
    }
}
