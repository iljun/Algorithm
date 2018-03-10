package BOJ_11812;


import java.io.*;

public class Main {

    static long N;
    static long K;
    static int Q;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NKQ = reader.readLine().split(" ");
        N = Long.parseLong(NKQ[0]);
        K = Long.parseLong(NKQ[1]);
        Q = Integer.parseInt(NKQ[2]);

        for (int i = 0; i < Q; i++) {

            String[] idx = reader.readLine().split(" ");
            long start = Long.parseLong(idx[0]);
            long end = Long.parseLong(idx[1]);

            if (K == 1) {
                writer.write(Long.toString((end - start) < 0 ? -(end - start) : end - start) + "\n");
                continue;
            }

            long cnt = 0;
            while (end != start) {
                if (start < end) {
                    long tmp = end;
                    end = start;
                    start = tmp;
                }

                start = (start + (K - 2)) / K;
                cnt++;
            }

            writer.write(Long.toString(cnt) + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }


}
