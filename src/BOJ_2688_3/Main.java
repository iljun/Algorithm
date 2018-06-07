package BOJ_2688_3;

import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 2
 * Time: 오후 12:44
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
    static long dp[][] = new long[66][10];

    public void init(){
        for(int i=0; i<10 ;i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<66; i++) {
            for(int j=0; j<10; j++){
                for(int k=j;k<10;k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
    }

    public String solve(int n){
        long result = 0;
        for(int i=0; i<10; i++){
            result+= dp[n][i];
        }

        return String.valueOf(result);
    }
}