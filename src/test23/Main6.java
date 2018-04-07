package test23;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main6 {
    static int TC;
    static int W;
    static int N;
    static List<W> list;

    public static void main(String[] args) throws IOException {//O(N^M)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        TC = Integer.parseInt(reader.readLine());

        int cnt = 0;
        while (TC-- > 0) {
            cnt++;
            writer.write("#" + String.valueOf(cnt) + "\n");
            W = Integer.parseInt(reader.readLine());
            N = Integer.parseInt(reader.readLine());

            list = new ArrayList<>();

            int result = 0;
            String[] input;
            for (int i = 0; i < N; i++) {
                input = reader.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                list.add(new W(x, y));
                result += x * y;
            }

            if (W == 0) {
                writer.write("0\n");
                continue;
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                for (int j = list.get(i).count; j >= 0; j--) {
                    if (result - list.get(i).weight >= W) {
                        result = result - list.get(i).weight;
                        list.get(i).count--;
                    }
                }
            }


            if (result != W) {
                writer.write("FAIL\n");
            } else {
                for (int i = 0; i < list.size(); i++) {
                    String tmp = list.get(i).weight + " " + list.get(i).count;
                    writer.write(tmp + "\n");
                }
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}

class W {
    int weight;
    int count;

    public W(int weight, int count) {
        this.weight = weight;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("W( weight = %d , count = %d)", this.weight, this.count);
    }
}
