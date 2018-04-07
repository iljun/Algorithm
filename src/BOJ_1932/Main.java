package BOJ_1932;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(reader.readLine());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        String[] input;
        for (int i = 1; i < N + 1; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < i; j++) {
                list[i - 1].add(Integer.parseInt(input[j]));
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < list[i+1].size()-1; j++) {
                list[i].set(j,list[i].get(j)+Math.max(list[i+1].get(j),list[i+1].get(j+1)));
            }
        }

        writer.write(String.valueOf(list[0].get(0)));

        reader.close();
        writer.flush();
        writer.close();
    }
}