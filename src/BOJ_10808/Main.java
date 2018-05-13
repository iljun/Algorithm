package BOJ_10808;

import java.io.*;
import java.util.Arrays;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 13
 * Time: 오후 4:47
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = reader.readLine().toCharArray();

        writer.write(solve(input));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(char[] input){
        int[] result = new int[26];
        for(int i=0; i<input.length;i++){
            result[input[i]-97]++;
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<result.length; i++){
            builder.append(result[i]).append(" ");
        }
        return builder.toString();
    }
}
