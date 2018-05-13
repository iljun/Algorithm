package BOJ_1100;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 13
 * Time: 오후 4:40
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] input = new String[8][8];

        String[] inputs;
        for (int i = 0; i < 8; i++) {
            inputs = reader.readLine().split("");
            for (int j = 0; j < 8; j++) {
                input[i][j] = inputs[j];
            }
        }
        writer.write(String.valueOf(solve(input)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(String[][] input) {

        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int j;
            if (i % 2 == 0) {
                j = 0;
            } else
                j = 1;

            for (; j < 8; j = j + 2) {
                if(input[i][j].equals("F"))
                    cnt++;
            }
        }

        return cnt;
    }
}
