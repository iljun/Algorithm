package BOJ_2908;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 12
 * Time: 오후 12:04
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        writer.write(solve(input));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(String[] input) {
        char[] a = input[0].toCharArray();
        char[] b = input[1].toCharArray();

        String A="";
        String B="";
        for (int i = a.length - 1; i > -1; i--) {
            A+=a[i];
            B+=b[i];
        }

        return Integer.parseInt(A) > Integer.parseInt(B) ? A : B;

    }
}
