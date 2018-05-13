package BOJ_10987;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 13
 * Time: 오후 5:22
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
        int cnt=0;
        for(int i=0; i<input.length; i++){
            if(input[i]=='a' || input[i]=='e' || input[i]=='i' || input[i]=='o' || input[i]=='u')
                cnt++;
        }

        return String.valueOf(cnt);
    }
}
