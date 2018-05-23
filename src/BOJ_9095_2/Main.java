package BOJ_9095_2;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 23
 * Time: 오후 6:55
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        init();
        while(t-->0){
            int n = Integer.parseInt(reader.readLine());

            writer.write(solve(n)+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }
    static int[] dp = new int[12];
    public void init(){
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<12; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
    }

    public String solve(int n){
        return String.valueOf(dp[n]);
    }
}
