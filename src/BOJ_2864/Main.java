package BOJ_2864;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 12
 * Time: 오전 11:42
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        writer.write(solve(input));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(String[] input){
        StringBuilder builder = new StringBuilder();
        String a = input[0];
        String b = input[1];

        a=a.replaceAll("6","5");
        b=b.replaceAll("6","5");

        int min = Integer.parseInt(a) + Integer.parseInt(b);

        a=a.replaceAll("5","6");
        b=b.replaceAll("5","6");

        int max = Integer.parseInt(a) + Integer.parseInt(b);

        builder.append(min).append(" ").append(max);

        return builder.toString();
    }
}
