package BOJ_1010;

import java.io.*;
import java.math.BigInteger;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 6
 * Time: 오전 10:31
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        int n;
        int m;
        String[] input;

        while (t-- > 0) {
            input = reader.readLine().split(" ");

            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            writer.write(String.valueOf(solve(n, m)) + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    // mCn TODO BigInteger를 사용하지 않고 구현하기
    public String solve(int n, int m) {
        BigInteger num = new BigInteger("1");

        if(n==m)
            return "1";
        else{
            for(int i=m; i>m-n; i--){
                num = num.multiply(BigInteger.valueOf(i));
            }

            for(int i=n; i>0; i--){
                num = num.divide(BigInteger.valueOf(i));
            }

        }

        return num.toString();
    }

}
