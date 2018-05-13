package BOJ_5622;

import java.io.*;
import java.util.Arrays;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 13
 * Time: 오후 4:52
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
        int[] result = new int[]{3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
        int cnt=0;
        for(int i=0; i<input.length; i++){
            cnt+=result[input[i]-65];

        }

        return String.valueOf(cnt);
    }
}
