package BOJ_5598;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 13
 * Time: 오후 5:28
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
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<input.length; i++){
            if(input[i]>67){
                builder.append((char)(input[i]-3));
            }else{
                builder.append((char)(input[i]+23));
            }
        }

        return builder.toString();
    }
}
