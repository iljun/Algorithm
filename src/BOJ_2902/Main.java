package BOJ_2902;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 13
 * Time: 오후 5:17
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();

        writer.write(solve(input));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(String input) {
        String[] list = input.split("-");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < list.length; i++) {
            builder.append(list[i].substring(0, 1));
        }

        return builder.toString();
    }
}
