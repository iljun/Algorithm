package BOJ_11656;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 13
 * Time: 오후 4:33
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();

        writer.write(solve(input));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(String input){
        List<String> result = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            result.add(input.substring(i,input.length()));
        }

        Collections.sort(result);
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<result.size(); i++){
            builder.append(result.get(i)).append("\n");
        }
        return builder.toString();
    }
}
